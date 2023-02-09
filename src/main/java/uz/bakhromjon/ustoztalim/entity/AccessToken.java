package uz.bakhromjon.ustoztalim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.constant.Constants;
import uz.bakhromjon.ustoztalim.util.BaseUtils;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name = "AccessToken")
@Table(name = "access_token")
public class AccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private String token = BaseUtils.generateUniqueString(Constants.TOKEN_LENGTH);
    private LocalDateTime expireAt = LocalDateTime.now().plusSeconds(Constants.ACCESS_TOKEN_EXPIRATION_S);

    public static AccessToken create(User user) {
        AccessToken accessToken = new AccessToken();
        accessToken.setUser(user);
        return accessToken;
    }

    public boolean isExpired() {
        return this.expireAt.isBefore(LocalDateTime.now());
    }
}
