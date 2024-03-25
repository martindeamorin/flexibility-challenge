package ar.com.plug.examen.infrastructure.persistence.impl;

import ar.com.plug.examen.domain.model.Customer;
import ar.com.plug.examen.domain.persistence.CustomerPersistence;
import ar.com.plug.examen.global.exception.PaymentRestException;
import ar.com.plug.examen.infrastructure.entity.CustomerEntity;
import ar.com.plug.examen.infrastructure.entity.ProductEntity;
import ar.com.plug.examen.infrastructure.persistence.jpa.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static ar.com.plug.examen.global.exception.PaymentException.CUSTOMER_NOT_FOUND;
import static ar.com.plug.examen.global.mapper.CustomerMapper.MAPPER;

@Repository
@RequiredArgsConstructor
public class CustomerPersistenceImpl implements CustomerPersistence {
    private final CustomerJpaRepository customerJpaRepository;

    @Override
    public Customer find(Long id) {
        return MAPPER.toDomain(customerJpaRepository.findById(id).orElseThrow(() -> new PaymentRestException(CUSTOMER_NOT_FOUND)));
    }

    @Override
    public void create(Customer customer) {
        customerJpaRepository.save(MAPPER.toEntity(customer));
    }

    @Override
    public void delete(Long id) {
        customerJpaRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Customer updated) {
        CustomerEntity old = customerJpaRepository.findById(id).get();
        MAPPER.toUpdatedEntity(updated, old);
        customerJpaRepository.save(old);
    }

    @Override
    public boolean exists(Long id) {
        return customerJpaRepository.existsById(id);
    }
}
