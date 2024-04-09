package ar.com.plug.examen.application.dto.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateProductDto {
    @NotBlank(message = "Name is mandatory.")
    @Size(message = "Name musn't exceed 32 characters.", max = 32)
    private String name;
    @NotBlank(message = "Description is mandatory.")
    @Size(message = "Description musn't exceed 255 characters.", max = 255)
    private String description;
    @NotNull(message = "Price is mandatory.")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 7, fraction = 2, message = "Price must be formatted with 2 decimals.")
    private BigDecimal price;
}
