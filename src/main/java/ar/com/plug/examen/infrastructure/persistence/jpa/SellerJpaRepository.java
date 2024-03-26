package ar.com.plug.examen.infrastructure.persistence.jpa;

import ar.com.plug.examen.infrastructure.entity.SellerEntity;
import org.springframework.data.repository.CrudRepository;

public interface SellerJpaRepository extends CrudRepository<SellerEntity, Long> {

}
