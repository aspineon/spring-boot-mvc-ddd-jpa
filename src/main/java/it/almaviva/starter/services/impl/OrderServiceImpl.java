package it.almaviva.starter.services.impl;

import it.almaviva.starter.domain.jpa.entities.OrderEntity;
import it.almaviva.starter.repositories.CustomerRepository;
import it.almaviva.starter.repositories.OrderItemRepository;
import it.almaviva.starter.repositories.OrderRepository;
import it.almaviva.starter.repositories.RetailItemRepository;
import it.almaviva.starter.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RetailItemRepository retailItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderEntity> getAllOrders() {
        return null;
    }

    @Override
    public Optional<OrderEntity> getSingleOrder(Long orderId) {
        return Optional.empty();
    }

    @Override
    public void insertOrder() {
    }

    @Override
    public void insertOrderItemIntoOrder() {
    }
}
