package ar.com.plug.examen.domain.service;

import ar.com.plug.examen.domain.model.Customer;

public interface CustomerService {
    Customer find(Long id);

    void create(Customer customer);

    void delete(Long id);

    void update(Long id, Customer customer);

    void exists(Long id);
}
