package ar.com.plug.examen.infrastructure.persistence.impl;

import ar.com.plug.examen.domain.model.Seller;
import ar.com.plug.examen.domain.persistence.SellerPersistence;
import ar.com.plug.examen.global.exception.PaymentRestException;
import ar.com.plug.examen.infrastructure.entity.SellerEntity;
import ar.com.plug.examen.infrastructure.persistence.jpa.SellerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import static ar.com.plug.examen.global.exception.PaymentException.CUSTOMER_NOT_FOUND;
import static ar.com.plug.examen.global.exception.PaymentException.SELLER_NOT_FOUND;
import static ar.com.plug.examen.global.mapper.SellerMapper.MAPPER;

@Repository
@RequiredArgsConstructor
public class SellerPersistenceImpl implements SellerPersistence {
    private final SellerJpaRepository sellerJpaRepository;

    @Override
    public Seller find(Long id) {
        return MAPPER.toDomain(sellerJpaRepository.findById(id).orElseThrow(() -> new PaymentRestException(SELLER_NOT_FOUND)));
    }

    @Override
    public void create(Seller seller) {
        sellerJpaRepository.save(MAPPER.toEntity(seller));
    }

    @Override
    public void delete(Long id) {
        try {
            sellerJpaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignored){};
    }

    @Override
    public void update(Long id, Seller updated) {
        SellerEntity old = sellerJpaRepository
                .findById(id)
                .orElseThrow(() -> new PaymentRestException(SELLER_NOT_FOUND));
        MAPPER.toUpdatedEntity(updated, old);
        sellerJpaRepository.save(old);
    }

    @Override
    public void exists(Long id) {
        if(!sellerJpaRepository.existsById(id)){
            throw new PaymentRestException(SELLER_NOT_FOUND);
        }
    }
}
