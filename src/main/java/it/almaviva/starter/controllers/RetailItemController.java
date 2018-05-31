package it.almaviva.starter.controllers;

import it.almaviva.starter.services.RetailItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retail-items")
public class RetailItemController {

    @Autowired
    private RetailItemService retailItemService;

    @GetMapping("/register")
    public ResponseEntity<?> registerRetailItem() {
        retailItemService.registerRandomRetailItem();
        return ResponseEntity.ok().build();
    }
}
