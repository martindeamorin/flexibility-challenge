package ar.com.plug.examen.domain.service.impl;

import ar.com.plug.examen.domain.model.Seller;
import ar.com.plug.examen.domain.persistence.SellerPersistence;
import ar.com.plug.examen.domain.service.SellerService;
import ar.com.plug.examen.global.exception.PaymentException;
import ar.com.plug.examen.global.exception.PaymentRestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final SellerPersistence sellerPersistence;

    @Override
    public Seller find(Long id) {
        return sellerPersistence.find(id);
    }

    @Override
    public void create(Seller seller) {
        sellerPersistence.create(seller);
    }

    @Override
    public void delete(Long id) {
        sellerPersistence.delete(id);
    }

    @Override
    public void update(Long id, Seller seller) {
        sellerPersistence.update(id, seller);

    }

    @Override
    public void exists(Long id) {
        sellerPersistence.exists(id);
    }
}
