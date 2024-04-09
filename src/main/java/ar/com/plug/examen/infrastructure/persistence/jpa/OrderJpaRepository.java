package ar.com.plug.examen.infrastructure.persistence.jpa;

import ar.com.plug.examen.infrastructure.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderJpaRepository extends CrudRepository<OrderEntity, Long> {
}
