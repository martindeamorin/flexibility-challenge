package ar.com.plug.examen.domain.service;

import ar.com.plug.examen.domain.model.Product;

public interface ProductService {
    Product find(Long id);
    void create(Product product);
    void delete(Long id);
}
