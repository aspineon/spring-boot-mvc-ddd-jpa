package it.almaviva.starter.rest.controllers;

import it.almaviva.starter.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public ResponseEntity<?> fetchAllOrders() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> fetchSingleOrder() {
        return ResponseEntity.ok().build();
    }

    @PostMapping(value="", consumes={"application/json"})
    public ResponseEntity<?> registerOrder() {
        return ResponseEntity.ok().build();
    }

    @PostMapping(value="/{orderId}", consumes = "application/json")
    public ResponseEntity<?> addOrderItemToOrder() {
        return ResponseEntity.ok().build();
    }
}
