package ar.com.plug.examen.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@Builder
public class Order {
    private Long id;
    private List<ProductSnapshot> products;
    private BigDecimal total;
    private Boolean isAuthorized;
    private Customer customer;

    public List<Long> retrieveProductsIds() {
        return products
                .stream()
                .map(ProductSnapshot::getProductId)
                .collect(Collectors.toList());

    }
    public void setTotal() {
        this.total = products
                .stream()
                .map(product -> getPriceByQuantity(product.getPrice(), product.getQuantity()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.FLOOR);
    }

    private BigDecimal getPriceByQuantity(BigDecimal price, Long quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

}
