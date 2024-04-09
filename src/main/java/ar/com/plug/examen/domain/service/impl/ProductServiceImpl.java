package ar.com.plug.examen.domain.service.impl;

import ar.com.plug.examen.domain.model.Product;
import ar.com.plug.examen.domain.persistence.ProductPersistence;
import ar.com.plug.examen.domain.service.ProductService;
import ar.com.plug.examen.domain.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductPersistence productPersistence;
    private final SellerService sellerService;

    @Override
    public Product find(Long id) {
        return productPersistence.find(id);
    }

    @Override
    public List<Product> findAll(List<Long> ids) {
        return productPersistence.findAll(ids);
    }

    @Override
    public void create(Product product) {
        sellerService.exists(product.getSeller().getId());
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
