package it.almaviva.starter.repositories;

import it.almaviva.starter.domain.jpa.entities.OrderItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long> {
}
