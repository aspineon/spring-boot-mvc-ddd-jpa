package it.almaviva.starter.domain.description.entities;

import it.almaviva.starter.domain.BaseEntity;

public interface Customer extends BaseEntity<Customer> {

    String getFirstName();

    String getLastName();
}
