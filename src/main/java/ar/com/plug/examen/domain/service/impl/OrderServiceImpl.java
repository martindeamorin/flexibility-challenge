package ar.com.plug.examen.domain.service.impl;

import ar.com.plug.examen.domain.model.Order;
import ar.com.plug.examen.domain.model.Product;
import ar.com.plug.examen.domain.persistence.OrderPersistence;
import ar.com.plug.examen.domain.service.CustomerService;
import ar.com.plug.examen.domain.service.OrderService;
import ar.com.plug.examen.domain.service.ProductService;
import static ar.com.plug.examen.global.mapper.ProductMapper.MAPPER;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderPersistence orderPersistence;
    private final ProductService productService;
    private final CustomerService customerService;
    @Override
    public Order find(Long id) {
        return orderPersistence.find(id);
    }

    @Override
    public void create(Order order) {
        customerService.exists(order.getCustomer().getId());
        List<Product> products = productService.findAll(order.retrieveProductsIds());
        MAPPER.toDomain(order.getProducts(), products);
        order.setTotal();
        orderPersistence.create(order);
    }

    @Override
    public void delete(Long id) {
        orderPersistence.delete(id);
    }

    @Override
    public void authorize(Long id) {
        orderPersistence.authorize(id);
    }
}
