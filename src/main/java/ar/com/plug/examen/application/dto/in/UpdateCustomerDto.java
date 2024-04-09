package ar.com.plug.examen.application.dto.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCustomerDto {
    @NotBlank(message = "Name is mandatory.")
    @Size(message = "Name musn't exceed 32 characters.", max = 32)
    private String name;
    @NotBlank(message = "Last name is mandatory.")
    @Size(message = "Last name musn't exceed 64 characters.", max = 64)
    private String lastName;
    @NotNull(message = "Age is mandatory")
    @Min(value = 18, message = "Customer age should be greater or equal than 18.")
    private Integer age;
}
