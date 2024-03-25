package ar.com.plug.examen.domain.persistence;

import ar.com.plug.examen.domain.model.Customer;

public interface CustomerPersistence {
    Customer find(Long id);

    void create(Customer customer);

    void delete(Long id);

    void update(Long id, Customer customer);

    boolean exists(Long id);
}
