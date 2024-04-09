package ar.com.plug.examen.domain.service;

import ar.com.plug.examen.domain.model.Order;

public interface OrderService {

    Order find(Long id);

    void create(Order domain);

    void delete(Long id);

    void authorize(Long id);
}
