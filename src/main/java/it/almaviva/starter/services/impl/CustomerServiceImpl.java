package it.almaviva.starter.services.impl;

import com.google.common.collect.Lists;
import it.almaviva.starter.domain.jpa.entities.CustomerEntity;
import it.almaviva.starter.repositories.CustomerRepository;
import it.almaviva.starter.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> getAllCustomers() {
        Iterable<CustomerEntity> customers =
                customerRepository.findAll();
        return Lists.newArrayList(customers);
    }

    public CustomerEntity insertCustomer(String firstName, String lastName) {
        CustomerEntity customer = new CustomerEntity(firstName, lastName);
        return customerRepository.save(customer);
    }
}
