package uz.bakhromjon.ustoztalim.exceptions.compileTime;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author : Ahrorjon Isroilov
 * @project : nomakler
 **/
public class UnauthorizedException extends ApiException {
    public UnauthorizedException(String message, Object data) {
        super(message, HttpStatus.UNAUTHORIZED, data);
    }

    public static void throwException(String message, String key, Object keyValue) throws UnauthorizedException {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, keyValue);
        throw new UnauthorizedException(message, map);
    }

    public static void throwException(String message, Object data) throws UnauthorizedException {
        throw new UnauthorizedException(message, data);
    }
}
