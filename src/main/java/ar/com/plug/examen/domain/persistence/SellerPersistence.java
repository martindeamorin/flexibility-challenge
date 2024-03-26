package ar.com.plug.examen.domain.persistence;

import ar.com.plug.examen.domain.model.Seller;

public interface SellerPersistence {
    Seller find(Long id);

    void create(Seller seller);

    void delete(Long id);

    void update(Long id, Seller seller);

}
