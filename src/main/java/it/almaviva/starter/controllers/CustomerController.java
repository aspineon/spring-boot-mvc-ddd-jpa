package it.almaviva.starter.controllers;

import it.almaviva.starter.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public ResponseEntity<?> registerCustomer() {
        customerService.registerRandomCustomer();
        return ResponseEntity.ok().build();
    }
}
