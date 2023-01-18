package uz.bakhromjon.ustoztalim.exceptions.compileTime;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class AccessDeniedException extends ApiException {

    public AccessDeniedException(String message, Object data) {
        super(message, HttpStatus.FORBIDDEN, data);
    }

    public static void throwException(String message, String key, Object keyValue) throws BadCredentialsException, AccessDeniedException {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, keyValue);
        throw new AccessDeniedException(message, map);
    }

    public static void throwException(String message, Object data) throws BadCredentialsException, AccessDeniedException {
        throw new AccessDeniedException(message, data);
    }
}
