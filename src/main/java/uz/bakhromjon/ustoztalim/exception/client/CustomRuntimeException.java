package uz.bakhromjon.ustoztalim.exception.client;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author : Bakhromjon Khasanboyev
 **/
import lombok.Setter;


@Setter
@Getter
public class CustomRuntimeException extends RuntimeException {
    private HttpStatus status;
    private Object data;

    public CustomRuntimeException(String message, HttpStatus status, Object data) {
        super(message);
        this.status = status;
        this.data = data;
    }

    public CustomRuntimeException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public CustomRuntimeException(Object data, HttpStatus status) {
        this.status = status;
        this.data = data;
    }


}
