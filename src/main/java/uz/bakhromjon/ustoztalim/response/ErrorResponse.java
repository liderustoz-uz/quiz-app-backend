package uz.bakhromjon.ustoztalim.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import uz.bakhromjon.ustoztalim.exception.user.ApiException;

import java.io.Serializable;

/**
 * @author : Ahrorjon Isroilov
 * @project : nomakler
 **/
@Data
public class ErrorResponse implements Serializable {
    @Schema(example = "", description = "Error simple message")
    private String error;

    @Schema(example = "", description = "Path which error is happened")
    private String path;

    @Schema(example = "", description = "Error localized message")
    private String message;

    @Schema(example = "", description = "Error data")
    private Object data;


    public ErrorResponse(String error, String path, String message, Object data) {
        setError(error);
        setPath(path);
        setMessage(message);
        setData(data);
    }

    public static ErrorResponse build(ApiException e, HttpServletRequest request) {
        return new ErrorResponse(
                e.getClass().getSimpleName(),
                request.getRequestURI(),
                e.getLocalizedMessage(),
                e.getData()
        );
    }
}
