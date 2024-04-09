package ar.com.plug.examen.domain.service;

import ar.com.plug.examen.domain.model.Seller;

public interface SellerService {
    Seller find(Long id);

    void create(Seller seller);

    void delete(Long id);

    void update(Long id, Seller seller);

    void exists(Long id);
}
