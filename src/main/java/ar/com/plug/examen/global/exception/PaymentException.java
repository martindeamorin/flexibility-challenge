package ar.com.plug.examen.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum PaymentException {
    PRODUCT_NOT_FOUND(
            "The product couldn't be found.",
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value()
    ),
    CUSTOMER_NOT_FOUND(
            "The customer couldn't be found.",
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value()
    );

    private final String message;
    private final String httpStatus;
    private final int httpStatusCode;
    PaymentException(String message, String httpStatus, int httpStatusCode) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatusCode;
    }

}
