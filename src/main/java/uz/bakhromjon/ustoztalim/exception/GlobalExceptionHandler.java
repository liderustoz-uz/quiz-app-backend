package uz.bakhromjon.ustoztalim.exception;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import uz.bakhromjon.ustoztalim.exception.user.ApiException;
import uz.bakhromjon.ustoztalim.exception.client.CustomRuntimeException;
import uz.bakhromjon.ustoztalim.response.ErrorResponse;
import uz.bakhromjon.ustoztalim.response.GenericResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ApiResponses(value = {@ApiResponse(description = "Api response")})
    public GenericResponse<?> apiException(ApiException e, ServletWebRequest webRequest) {
        return new GenericResponse<>(
                new ErrorResponse(
                        e.getClass().getSimpleName(),
                        webRequest.getRequest().getRequestURI(),
                        e.getLocalizedMessage(),
                        e.getData()
                ),
                e.getStatus()
        );
    }


    @ExceptionHandler(CustomRuntimeException.class)
    @ApiResponses(value = {@ApiResponse(description = "Runtime Exception")})
    public GenericResponse<ErrorResponse> customRuntimeException(CustomRuntimeException e, ServletWebRequest webRequest) {
        return new GenericResponse<>(
                new ErrorResponse(
                        e.getClass().getSimpleName(),
                        webRequest.getRequest().getRequestURI(),
                        e.getLocalizedMessage(),
                        e.getData()
                ),
                e.getStatus()
        );
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GenericResponse<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e, ServletWebRequest webRequest) {
        return new GenericResponse<>(
                new ErrorResponse(
                        e.getClass().getSimpleName(),
                        webRequest.getRequest().getRequestURI(),
                        e.getBody().getDetail(),
                        e.getDetailMessageArguments()
                ),
                HttpStatus.valueOf(e.getStatusCode().value())
        );
    }
}
