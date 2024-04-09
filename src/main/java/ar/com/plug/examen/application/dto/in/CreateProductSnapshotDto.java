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
public class CreateProductSnapshotDto {
    @NotNull(message = "Product ID is mandatory.")
    @Positive(message = "Product ID must be positive.")
    private Long productId;
    @NotNull(message = "Quantity is mandatory.")
    @Positive(message = "Quantity must be positive.")
    private Long quantity;
}
