package uz.bakhromjon.ustoztalim.auth;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.ustoztalim.auth.request.LoginRequest;
import uz.bakhromjon.ustoztalim.auth.request.SignupRequest;
import uz.bakhromjon.ustoztalim.controller.base.AbstractController;
import uz.bakhromjon.ustoztalim.exception.user.BadCredentialsException;
import uz.bakhromjon.ustoztalim.exception.user.InvalidDataException;
import uz.bakhromjon.ustoztalim.exception.user.NotAcceptableException;
import uz.bakhromjon.ustoztalim.repository.UserRepository;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:54
 **/

@RestController
@RequestMapping("/auth")
public class AuthController extends AbstractController<AuthService> {
    public AuthController(AuthService service) {
        super(service);
    }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder encoder;


    @Operation(summary = "Registratsiya qilish")
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignupRequest signUpRequest) throws NotAcceptableException {
        return service.signUp(signUpRequest);
    }

    @Operation(summary = "Signin qilish")
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody LoginRequest loginRequest) throws BadCredentialsException {
        return service.signIn(loginRequest);
    }

    @Operation(summary = "SignOut qilish")
    @PostMapping("/signout")
    public ResponseEntity<?> signOut(@RequestParam String token) throws InvalidDataException {
        return service.signOut(token);
    }
}
