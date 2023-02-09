package uz.bakhromjon.ustoztalim.exception.user;

import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * @author : Ahrorjon Isroilov
 * @project : nomakler
 **/
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ApiException extends IOException {

    private HttpStatus status;
    private Object data;

    public ApiException(String message, HttpStatus httpStatus, Object data) {
        super(message);
        this.status = httpStatus;
        this.data = data;
    }


}
