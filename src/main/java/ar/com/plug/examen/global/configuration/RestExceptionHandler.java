package ar.com.plug.examen.global.configuration;

import ar.com.plug.examen.application.dto.PaymentExceptionDto;
import ar.com.plug.examen.global.exception.PaymentRestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {PaymentRestException.class})
    public ResponseEntity<PaymentExceptionDto> handlePaymentRestException(PaymentRestException exception) {
        int httpStatusCode = exception
                .getPaymentException()
                .getHttpStatusCode();
        String message = exception
                .getPaymentException()
                .getMessage();
        String httpStatus = exception
                .getPaymentException()
                .getHttpStatus();

        return ResponseEntity
                .status(httpStatusCode)
                .body(PaymentExceptionDto
                        .builder()
                        .httpStatus(httpStatus)
                        .message(message)
                        .build()
                );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST.value())
                .body(PaymentExceptionDto
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST.toString())
                        .errors(errors)
                        .build()
                );
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<PaymentExceptionDto> handleFallback(Exception exception) {
        log.info(exception.getClass().toString());
        exception.printStackTrace();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(httpStatus.value())
                .body(PaymentExceptionDto
                        .builder()
                        .httpStatus(httpStatus.toString())
                        .message("Unexpected error occurred in server.")
                        .build()
                );
    }
}