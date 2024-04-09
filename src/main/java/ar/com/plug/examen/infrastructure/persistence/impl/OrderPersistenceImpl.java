package ar.com.plug.examen.infrastructure.persistence.impl;

import ar.com.plug.examen.domain.model.Order;
import ar.com.plug.examen.domain.persistence.OrderPersistence;

import static ar.com.plug.examen.global.exception.PaymentException.*;
import static ar.com.plug.examen.global.mapper.OrderMapper.MAPPER;

import ar.com.plug.examen.global.exception.PaymentRestException;
import ar.com.plug.examen.global.mapper.CustomerMapper;
import ar.com.plug.examen.infrastructure.entity.OrderEntity;
import ar.com.plug.examen.infrastructure.entity.ProductEntity;
import ar.com.plug.examen.infrastructure.persistence.jpa.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderPersistenceImpl implements OrderPersistence {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order find(Long id) {
        return MAPPER.toDomain(orderJpaRepository.findById(id).orElseThrow(() -> new PaymentRestException(ORDER_NOT_FOUND)));
    }

    @Override
    public void create(Order order) {
        orderJpaRepository.save(MAPPER.toEntity(order));
    }

    @Override
    public void delete(Long id) {
        try {
            orderJpaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) {
        }
    }

    @Override
    public void authorize(Long id) {
        OrderEntity toUpdate = orderJpaRepository
                .findById(id)
                .orElseThrow(() -> new PaymentRestException(ORDER_NOT_FOUND));
        if(toUpdate.getIsAuthorized()) {
            throw new PaymentRestException(ORDER_ALREADY_AUTHORIZED);
        }
        toUpdate.setIsAuthorized(true);
        orderJpaRepository.save(toUpdate);
    }



}
