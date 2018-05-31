package it.almaviva.starter.services;

import it.almaviva.starter.domain.jpa.entities.CustomerEntity;
import it.almaviva.starter.domain.jpa.entities.OrderEntity;
import it.almaviva.starter.domain.jpa.entities.OrderItemEntity;
import it.almaviva.starter.domain.jpa.entities.RetailItemEntity;
import it.almaviva.starter.repositories.CustomerRepository;
import it.almaviva.starter.repositories.OrderItemRepository;
import it.almaviva.starter.repositories.OrderRepository;
import it.almaviva.starter.repositories.RetailItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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
    public Long registerOrder() {
        // retrieve the retail item using it's id
        RetailItemEntity retailItem = retailItemRepository.findById(1L).get();
        // retrieve the customer using it's id
        CustomerEntity customer = customerRepository.findById(1L).get();
        // create the an order Item
        OrderItemEntity orderItem = new OrderItemEntity(5, retailItem);
        Set<OrderItemEntity> orderItems = new HashSet<>();
        orderItems.add(orderItem);
        // orderItemRepository.save(orderItem);
        // creare an order
        OrderEntity order = new OrderEntity(orderItems, customer);
        return orderRepository.save(order).getId();
    }
}
