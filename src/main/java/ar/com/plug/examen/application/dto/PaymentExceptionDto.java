package ar.com.plug.examen.application.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentExceptionDto {
    private final String message;
    private final String httpStatus;
    private final int httpStatusCode;
}
