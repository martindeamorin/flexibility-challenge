package ar.com.plug.examen.application.dto.out;

import ar.com.plug.examen.domain.model.Customer;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FindOrderDto {
    private List<FindProductSnapshotDto> products;
    private BigDecimal total;
    private Boolean isAuthorized;
    private Customer customer;
}
