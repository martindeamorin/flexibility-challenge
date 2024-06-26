package ar.com.plug.examen.infrastructure.persistence.impl;


import ar.com.plug.examen.domain.model.Product;
import ar.com.plug.examen.domain.persistence.ProductPersistence;
import ar.com.plug.examen.global.exception.PaymentRestException;
import ar.com.plug.examen.infrastructure.entity.ProductEntity;
import ar.com.plug.examen.infrastructure.persistence.jpa.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static ar.com.plug.examen.global.exception.PaymentException.PRODUCTS_NOT_FOUND;
import static ar.com.plug.examen.global.exception.PaymentException.PRODUCT_NOT_FOUND;
import static ar.com.plug.examen.global.mapper.ProductMapper.MAPPER;

@Repository
@RequiredArgsConstructor
public class ProductPersistenceImpl implements ProductPersistence {
    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product find(Long id) {
        return MAPPER.toDomain(productJpaRepository.findById(id).orElseThrow(() -> new PaymentRestException(PRODUCT_NOT_FOUND)));
    }

    @Override
    public List<Product> findAll(List<Long> ids) {
        List<ProductEntity> products = productJpaRepository.findAllByIdIn(ids);
        failIfProductsNotFound(ids, products);
        return MAPPER.toDomain(products);
    }

    @Override
    public void create(Product product) {
        productJpaRepository.save(MAPPER.toEntity(product));
    }

    @Override
    public void delete(Long id) {
        try {
            productJpaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) {}
    }
    @Override
    public void update(Long id, Product updated) {
        ProductEntity toUpdate = productJpaRepository
                .findById(id)
                .orElseThrow(() -> new PaymentRestException(PRODUCT_NOT_FOUND));
        MAPPER.toUpdatedEntity(toUpdate, updated);
        productJpaRepository.save(toUpdate);
    }

    private void failIfProductsNotFound(List<Long> ids, List<ProductEntity> products) {
        if(products == null || products.isEmpty() || (products.size() != ids.size())) {
            throw new PaymentRestException(PRODUCTS_NOT_FOUND);
        }
    }
}
