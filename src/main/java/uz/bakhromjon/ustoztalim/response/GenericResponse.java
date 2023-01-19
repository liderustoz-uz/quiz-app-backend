package uz.bakhromjon.ustoztalim.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author : Ahrorjon Isroilov
 * @project : nomakler
 **/
@Getter
@Setter
public class GenericResponse<T> extends ResponseEntity<T> {
    private final Long serverTime = System.currentTimeMillis();

    public GenericResponse(T data, HttpStatus status) {
        super(data, status);
    }

    public static <T> GenericResponse ok(T data) {
        return new GenericResponse<>(data, HttpStatus.OK);
    }
}
