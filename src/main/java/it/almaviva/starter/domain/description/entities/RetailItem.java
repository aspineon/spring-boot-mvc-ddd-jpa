package it.almaviva.starter.domain.description.entities;

import it.almaviva.starter.domain.BaseEntity;
import it.almaviva.starter.domain.description.objects.Amount;

public interface RetailItem extends BaseEntity<RetailItem> {

    String getTitle();

    String getDescription();

    Amount getCurrentPrice();
}
