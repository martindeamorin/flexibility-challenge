package ar.com.plug.examen.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductSnapshot {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private Long productId;
    private Date snapshotDate;
}
