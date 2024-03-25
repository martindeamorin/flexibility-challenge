package ar.com.plug.examen.domain.persistence;

import ar.com.plug.examen.domain.model.Product;

public interface ProductPersistence {
    Product find(Long id);

    void create(Product product);

    void delete(Long id);

    void update(Long id, Product product);

    boolean exists(Long id);
}
