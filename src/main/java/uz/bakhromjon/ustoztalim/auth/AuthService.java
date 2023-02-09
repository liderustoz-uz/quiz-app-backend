package uz.bakhromjon.ustoztalim.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.bakhromjon.ustoztalim.auth.request.LoginRequest;
import uz.bakhromjon.ustoztalim.auth.request.SignupRequest;
import uz.bakhromjon.ustoztalim.constant.ErrorDataKeys;
import uz.bakhromjon.ustoztalim.constant.ErrorMessages;
import uz.bakhromjon.ustoztalim.entity.AccessToken;
import uz.bakhromjon.ustoztalim.entity.User;
import uz.bakhromjon.ustoztalim.enums.ERole;
import uz.bakhromjon.ustoztalim.exception.user.BadCredentialsException;
import uz.bakhromjon.ustoztalim.exception.user.InvalidDataException;
import uz.bakhromjon.ustoztalim.exception.user.NotAcceptableException;
import uz.bakhromjon.ustoztalim.mapper.AccessTokenMapper;
import uz.bakhromjon.ustoztalim.response.GenericResponse;
import uz.bakhromjon.ustoztalim.response.UserInfoResponse;
import uz.bakhromjon.ustoztalim.service.impl.AccessTokenService;
import uz.bakhromjon.ustoztalim.service.impl.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserService userService;

    private final PasswordEncoder encoder;
    private final AccessTokenService accessTokenService;
    private final AccessTokenMapper accessTokenMapper;


    public ResponseEntity<?> signIn(LoginRequest loginRequest) throws BadCredentialsException {
        User user = findUserByUsernameCredential(loginRequest.getUsername());
        matchesPassword(loginRequest.getPassword(), user.getPassword());

        AccessToken accessToken = AccessToken.create(user);
        accessToken = accessTokenService.save(accessToken);
        return ResponseEntity.ok(accessTokenMapper.toGetDTO(accessToken));
    }


    public ResponseEntity<?> signUp(SignupRequest signUpRequest) throws NotAcceptableException {
        checkUsernameForAvailable(signUpRequest.getUsername());

        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()), ERole.ROLE_USER);
        userService.save(user);

        AccessToken accessToken = AccessToken.create(user);
        accessToken = accessTokenService.save(accessToken);
        return ResponseEntity.ok(accessTokenMapper.toGetDTO(accessToken));
    }


    public ResponseEntity<?> signOut(String token) throws InvalidDataException {
        AccessToken accessToken = accessTokenService.getPersist(token);
        accessTokenService.delete(accessToken);
        return ResponseEntity.ok(true);
    }

    public User findUserByUsernameCredential(String username) throws BadCredentialsException {
        Optional<User> userOptional = userService.findByUsername(username);
        if (userOptional.isEmpty()) {
            BadCredentialsException.throwException(ErrorMessages.BAD_CREDENTIALS, ErrorDataKeys.USERNAME, username);
        }
        return userOptional.get();
    }

    public void matchesPassword(String rawPassword, String encodedPassword) throws BadCredentialsException {
        if (!encoder.matches(rawPassword, encodedPassword)) {
            BadCredentialsException.throwException(ErrorMessages.BAD_CREDENTIALS, ErrorDataKeys.PASSWORD, rawPassword);
        }
    }

    public void checkUsernameForAvailable(String username) throws NotAcceptableException {
        Boolean existsUser = userService.existsByUsername(username);
        if (existsUser != null && existsUser) {
            NotAcceptableException.throwException(ErrorMessages.USERNAME_ALREADY_TAKEN, ErrorDataKeys.USERNAME, username);
        }
    }

}
