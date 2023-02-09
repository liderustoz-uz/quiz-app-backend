package uz.bakhromjon.ustoztalim.dto.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.dto.user.UserGetDTO;

import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenGetDTO {
    private UserGetDTO user;
    private String token;
    private LocalDateTime expireAt;
}
