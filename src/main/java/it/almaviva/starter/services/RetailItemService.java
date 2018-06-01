package it.almaviva.starter.services;

import it.almaviva.starter.domain.jpa.entities.RetailItemEntity;

import java.util.List;

public interface RetailItemService {
    List<RetailItemEntity> getAllRetailItems();
    RetailItemEntity insertRetailItem(String title, String description, Integer price);
}
