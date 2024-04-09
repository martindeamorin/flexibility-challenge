package ar.com.plug.examen.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentExceptionDto {
    private final String message;
    private final String httpStatus;
    private final Map<String, String> errors;
}
