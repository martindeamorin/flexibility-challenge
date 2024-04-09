package ar.com.plug.examen.domain.service.impl;

import ar.com.plug.examen.domain.model.Customer;
import ar.com.plug.examen.domain.persistence.CustomerPersistence;
import ar.com.plug.examen.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerPersistence customerPersistence;
    @Override
    public Customer find(Long id) {
        return customerPersistence.find(id);
    }

    @Override
    public void create(Customer customer) {
        customerPersistence.create(customer);
    }

    @Override
    public void delete(Long id) {
        customerPersistence.delete(id);
    }

    @Override
    public void update(Long id, Customer customer) {
        customerPersistence.update(id, customer);
    }

    @Override
    public void exists(Long id) {
        customerPersistence.exists(id);
    }
}
