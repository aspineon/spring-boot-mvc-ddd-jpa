package it.almaviva.starter.services;

import it.almaviva.starter.domain.jpa.entities.CustomerEntity;
import it.almaviva.starter.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Long registerRandomCustomer() {
        String firstName = "FirstName " + UUID.randomUUID().toString();
        String lastName = "LastName " + UUID.randomUUID().toString();
        CustomerEntity randomCustomer = new CustomerEntity(firstName, lastName);
        return customerRepository.save(randomCustomer).getId();
    }
}
