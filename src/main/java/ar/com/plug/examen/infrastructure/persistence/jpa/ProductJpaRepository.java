package ar.com.plug.examen.infrastructure.persistence.jpa;

import ar.com.plug.examen.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductJpaRepository extends CrudRepository<ProductEntity, Long> {
}
