package uz.bakhromjon.ustoztalim.exceptions.runtime;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author : Ahrorjon Isroilov
 * @project : nomakler
 **/
public class BadRequestException extends CustomRuntimeException {
    public BadRequestException(String message, Object data) {
        super(message, HttpStatus.BAD_REQUEST, data);
    }
    public static void throwException(String message, String key, Object keyValue) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, keyValue);
        throw new BadRequestException(message, map);
    }

    public static void throwException(String message, Object data) {
        throw new BadRequestException(message, data);
    }
}
