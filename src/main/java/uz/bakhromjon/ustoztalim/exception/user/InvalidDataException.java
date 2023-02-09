package uz.bakhromjon.ustoztalim.exception.user;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author : Bakhromjon Khasanboyev
 **/
public class InvalidDataException extends ApiException {
    private InvalidDataException(String message, Object data) {
        super(message, HttpStatus.BAD_REQUEST, data);
    }

    public static void throwException(String message, String key, Object keyValue) throws InvalidDataException {
        HashMap<String, Object> map =  new HashMap<>();
        map.put(key, keyValue);
        throw new InvalidDataException(message, map);
    }

    public static void throwException(String message, Object data) throws InvalidDataException {
        throw new InvalidDataException(message, data);
    }
}
