package ar.com.plug.examen.infrastructure.persistence.jpa;

import ar.com.plug.examen.infrastructure.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerJpaRepository extends CrudRepository<CustomerEntity, Long> {
}
