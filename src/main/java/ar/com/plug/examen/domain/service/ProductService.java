package ar.com.plug.examen.domain.service;

import ar.com.plug.examen.domain.model.Product;

import java.util.List;

public interface ProductService {
    Product find(Long id);

    List<Product> findAll(List<Long> ids);

    void create(Product product);

    void delete(Long id);

    void update(Long id, Product product);
}
