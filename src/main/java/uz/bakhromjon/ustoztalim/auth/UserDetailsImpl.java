package uz.bakhromjon.ustoztalim.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.bakhromjon.ustoztalim.entity.User;
import uz.bakhromjon.ustoztalim.enums.ERole;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:46
 **/
@Getter
public class UserDetailsImpl implements UserDetails {

    private Long id;

    private String firstName;
    private String lastName;
    private String username;

    @JsonIgnore
    private String password;

    private ERole role;

    public UserDetailsImpl(Long id, String firstName, String lastName, String username, String password,
                           ERole role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}