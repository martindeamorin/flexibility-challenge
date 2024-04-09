package ar.com.plug.examen.application.dto.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrderDto {
    @NotEmpty(message = "Products are mandatory.")
    private List<@Valid CreateProductSnapshotDto> products;
    @NotNull(message = "Customer ID is mandatory.")
    @Positive(message = "Customer ID must be positive.")
    private Long customerId;
}
