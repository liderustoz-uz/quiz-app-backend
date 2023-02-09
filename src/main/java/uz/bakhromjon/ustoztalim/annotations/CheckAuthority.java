package uz.bakhromjon.ustoztalim.annotations;


import uz.bakhromjon.ustoztalim.enums.ERole;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuthority {
    ERole[] roles();
}
