package uz.bakhromjon.ustoztalim.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.bakhromjon.ustoztalim.configuration.SecurityConfig;
import uz.bakhromjon.ustoztalim.constant.ErrorMessages;
import uz.bakhromjon.ustoztalim.entity.AccessToken;
import uz.bakhromjon.ustoztalim.entity.User;
import uz.bakhromjon.ustoztalim.exception.user.UnauthorizedException;
import uz.bakhromjon.ustoztalim.response.ErrorResponse;
import uz.bakhromjon.ustoztalim.response.GenericResponse;
import uz.bakhromjon.ustoztalim.service.impl.AccessTokenService;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:49
 **/
public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private AccessTokenService accessTokenService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String accessToken = request.getHeader("Authorization");
        if (accessToken == null || !accessToken.startsWith("Bearer")) {
            UnauthorizedException exception = new UnauthorizedException(ErrorMessages.ACCESS_TOKEN_REQUIRED_THIS_RESOURCE, null);
            sendError(exception.getStatus(), ErrorResponse.build(exception, request), response);
            return;
        }
        accessToken = accessToken.substring(7);

        AccessToken accessTokenObj = accessTokenService.getPersist(accessToken);
        if (accessTokenObj.isExpired()) {
            UnauthorizedException exception = new UnauthorizedException(ErrorMessages.ACCESS_TOKEN_EXPIRED, null);
            sendError(exception.getStatus(), ErrorResponse.build(exception, request), response);
            return;
        }
        User user = accessTokenObj.getUser();
        UserDetailsImpl userDetails = UserDetailsImpl.build(user);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails,
                        null,
                        null);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return Arrays.stream(SecurityConfig.WHITE_LIST)
                .anyMatch(e -> new AntPathMatcher().match(e, request.getServletPath()));
    }

    private void sendError(HttpStatus status, ErrorResponse errorResponse, HttpServletResponse httpServletResponse) throws IOException {
        GenericResponse<ErrorResponse> genericResponse = new GenericResponse<>(errorResponse, status);
        ObjectMapper objectMapper = new ObjectMapper();
        httpServletResponse.setHeader("Content-Type", "application/json");
        httpServletResponse.getWriter().print(objectMapper.writeValueAsString(genericResponse));
        httpServletResponse.setStatus(status.value());
    }

}