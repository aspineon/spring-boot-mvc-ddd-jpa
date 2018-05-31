package it.almaviva.starter.repositories;

import it.almaviva.starter.domain.entities.RetailItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailItemRepository extends CrudRepository<RetailItem, Long> {
}
