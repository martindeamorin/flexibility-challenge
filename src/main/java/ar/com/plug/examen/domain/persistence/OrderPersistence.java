package ar.com.plug.examen.domain.persistence;

import ar.com.plug.examen.domain.model.Order;

public interface OrderPersistence {
    Order find(Long id);

    void create(Order customer);

    void delete(Long id);

    void authorize(Long id);
}
