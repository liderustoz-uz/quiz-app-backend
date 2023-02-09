package uz.bakhromjon.ustoztalim.annotations;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.bakhromjon.ustoztalim.auth.UserDetailsImpl;

@Component
@Aspect
public class CheckAuthorityExecutor {
    @Before(value = "@annotation(checkAuthority)")
    public void checkAuthority(CheckAuthority checkAuthority) {
        UserDetailsImpl session = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
