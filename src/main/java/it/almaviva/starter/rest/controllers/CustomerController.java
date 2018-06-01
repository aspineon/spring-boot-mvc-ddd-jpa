package it.almaviva.starter.rest.controllers;

import it.almaviva.starter.domain.jpa.entities.CustomerEntity;
import it.almaviva.starter.rest.commands.RegisterCustomer;
import it.almaviva.starter.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<?> fetchAllCustomers() {
        List<CustomerEntity> customers = customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @PostMapping(value="", consumes={"application/json"})
    public ResponseEntity<?> registerCustomer(@RequestBody RegisterCustomer command) {
        String firstName = command.getFirstName();
        String lastName = command.getLastName();
        CustomerEntity insertedCustomer =
                customerService.insertCustomer(firstName, lastName);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedCustomer);
    }
}