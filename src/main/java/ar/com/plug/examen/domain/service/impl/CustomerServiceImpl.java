package ar.com.plug.examen.domain.service.impl;

import ar.com.plug.examen.domain.model.Customer;
import ar.com.plug.examen.domain.persistence.CustomerPersistence;
import ar.com.plug.examen.domain.service.CustomerService;
import ar.com.plug.examen.global.exception.PaymentException;
import ar.com.plug.examen.global.exception.PaymentRestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerPersistence customerPersistence;

    @Autowired
    public CustomerServiceImpl(CustomerPersistence customerPersistence) {
        this.customerPersistence = customerPersistence;
    }

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
        failIfCustomerDoesntExists(id);
        customerPersistence.delete(id);
    }

    @Override
    public void update(Long id, Customer customer) {
        failIfCustomerDoesntExists(id);
        customerPersistence.update(id, customer);

    }

    private void failIfCustomerDoesntExists(Long id) {
        if(!customerPersistence.exists(id)) {
            throw new PaymentRestException(PaymentException.CUSTOMER_NOT_FOUND);
        }
    }
}
