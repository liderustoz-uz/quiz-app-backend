package uz.bakhromjon.ustoztalim.exceptions.compileTime;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author : Bakhromjon Khasanboyev
 **/
public class BadCredentialsException extends ApiException {
    public BadCredentialsException(String message, Object data) {
        super(message, HttpStatus.BAD_REQUEST, data);
    }


    public static void throwException(String message, String key, Object keyValue) throws BadCredentialsException {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, keyValue);
        throw new BadCredentialsException(message, map);
    }

    public static void throwException(String message, Object data) throws BadCredentialsException {
        throw new BadCredentialsException(message, data);
    }


}
