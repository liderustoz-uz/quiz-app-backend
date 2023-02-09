package uz.bakhromjon.ustoztalim.auth.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.constant.ValidationMessages;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:58
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    @NotEmpty(message = ValidationMessages.FIRST_NAME_NOT_EMPTY)
    private String firstName;

    @NotEmpty(message = ValidationMessages.LAST_NAME_NOT_EMPTY)
    private String lastName;

    @NotEmpty(message = ValidationMessages.USER_NAME_NOT_EMPTY)
    @Size(min = 4, max = 10, message = ValidationMessages.USERNAME_MAX_MIN)
    private String username;

    @NotEmpty(message = ValidationMessages.PASSWORD_NOT_EMPTY)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = ValidationMessages.PASSWORD_NOT_VALID)
    @Schema(example = "Ustoz123$",description = "")
    private String password;
}
