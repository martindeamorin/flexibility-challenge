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
    PRODUCTS_NOT_FOUND(
            "Some or all of the products could not be found.",
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value()
    ),
    ORDER_NOT_FOUND(
            "The order couldn't be found.",
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value()
    ),
    CUSTOMER_NOT_FOUND(
            "The customer couldn't be found.",
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value()
    ),
    SELLER_NOT_FOUND(
            "The seller couldn't be found.",
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value()
    ),
    ORDER_ALREADY_AUTHORIZED(
            "Order is already authorized.",
            HttpStatus.BAD_REQUEST.toString(),
            HttpStatus.BAD_REQUEST.value());

    private final String message;
    private final String httpStatus;
    private final int httpStatusCode;
    PaymentException(String message, String httpStatus, int httpStatusCode) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatusCode;
    }

}
