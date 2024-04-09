package ar.com.plug.examen.domain.persistence;

import ar.com.plug.examen.domain.model.Product;

import java.util.List;

public interface ProductPersistence {
    Product find(Long id);

    List<Product> findAll (List<Long> ids);

    void create(Product product);

    void delete(Long id);

    void update(Long id, Product product);
}
