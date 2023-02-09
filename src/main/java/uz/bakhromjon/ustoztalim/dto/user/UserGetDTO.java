package uz.bakhromjon.ustoztalim.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.enums.ERole;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserGetDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private ERole role;
}
