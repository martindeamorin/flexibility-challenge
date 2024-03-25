package ar.com.plug.examen.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String name;
    private String description;
    private BigDecimal price;
}
