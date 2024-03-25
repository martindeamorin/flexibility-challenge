package ar.com.plug.examen.domain.service.impl;

import ar.com.plug.examen.domain.model.Product;
import ar.com.plug.examen.domain.persistence.ProductPersistence;
import ar.com.plug.examen.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductPersistence productPersistence;

    @Autowired
    public ProductServiceImpl(ProductPersistence productPersistence) {
        this.productPersistence = productPersistence;
    }

    @Override
    public Product find(Long id) {
        return productPersistence.find(id);
    }

    @Override
    public void create(Product product) {
        productPersistence.create(product);
    }

    @Override
    public void delete(Long id) {
        productPersistence.delete(id);
    }
}
