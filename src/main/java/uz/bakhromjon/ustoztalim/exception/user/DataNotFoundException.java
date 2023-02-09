package uz.bakhromjon.ustoztalim.exception.user;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author : Ahrorjon Isroilov
 * @project : nomakler
 **/
public class DataNotFoundException extends ApiException {
    public DataNotFoundException(String message, Object data) {
        super(message, HttpStatus.NO_CONTENT, data);
    }

    public static void throwException(String message, String key, Object keyValue) throws DataNotFoundException {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, keyValue);
        throw new DataNotFoundException(message, map);
    }

    public static void throwException(String message, Object data) throws DataNotFoundException {
        throw new DataNotFoundException(message, data);
    }
}
