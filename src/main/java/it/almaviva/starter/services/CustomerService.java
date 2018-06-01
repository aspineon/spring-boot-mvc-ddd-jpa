package it.almaviva.starter.services;

import it.almaviva.starter.domain.jpa.entities.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getAllCustomers();
    CustomerEntity insertCustomer(String firstName, String lastName);
}
