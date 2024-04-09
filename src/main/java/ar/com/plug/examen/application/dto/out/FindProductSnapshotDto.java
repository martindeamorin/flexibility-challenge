package ar.com.plug.examen.application.dto.out;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FindProductSnapshotDto {
    private Long productId;
    private Long quantity;
    private String name;
    private String description;
    private BigDecimal price;
}
