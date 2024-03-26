package ar.com.plug.examen.domain.service.impl;

import ar.com.plug.examen.domain.model.Product;
import ar.com.plug.examen.domain.persistence.ProductPersistence;
import ar.com.plug.examen.domain.service.ProductService;
import ar.com.plug.examen.global.exception.PaymentException;
import ar.com.plug.examen.global.exception.PaymentRestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductPersistence productPersistence;

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

    @Override
    public void update(Long id, Product product) {
        productPersistence.update(id, product);
    }
}
