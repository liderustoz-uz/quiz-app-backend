package uz.bakhromjon.ustoztalim.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:39
 **/
public enum ERole implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;


    @Override
    public String getAuthority() {
        return name();
    }
}
