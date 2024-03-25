package ar.com.plug.examen.global.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
public class PaymentRestException extends RuntimeException {

    private final PaymentException paymentException;
    public PaymentRestException(PaymentException paymentException) {
        this.paymentException = paymentException;
    }
}
