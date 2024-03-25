package ar.com.plug.examen.global.configuration;

import ar.com.plug.examen.application.dto.PaymentExceptionDto;
import ar.com.plug.examen.global.exception.PaymentRestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
                        .httpStatusCode(httpStatusCode)
                        .httpStatus(httpStatus)
                        .message(message)
                        .build()
                );
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<PaymentExceptionDto> handleFallback(Exception exception) {
        log.info(exception.getMessage());
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(httpStatus.value())
                .body(PaymentExceptionDto
                        .builder()
                        .httpStatusCode(httpStatus.value())
                        .httpStatus(httpStatus.toString())
                        .message("Unexpected error occurred in server.")
                        .build()
                );
    }
}