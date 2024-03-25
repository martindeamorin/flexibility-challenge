package ar.com.plug.examen.infrastructure.persistence.impl;


import ar.com.plug.examen.domain.model.Product;
import ar.com.plug.examen.domain.persistence.ProductPersistence;
import ar.com.plug.examen.global.exception.PaymentRestException;
import ar.com.plug.examen.infrastructure.entity.ProductEntity;
import ar.com.plug.examen.infrastructure.persistence.jpa.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Map;
import org.springframework.stereotype.Repository;

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
    public void create(Product product) {
        productJpaRepository.save(MAPPER.toEntity(product));
    }

    @Override
    public void delete(Long id) {
        productJpaRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Product updated) {
        ProductEntity old = productJpaRepository.findById(id).get();
        MAPPER.toUpdatedEntity(updated, old);
        productJpaRepository.save(old);
    }

    @Override
    public boolean exists(Long id) {
        return productJpaRepository.existsById(id);
    }
}
