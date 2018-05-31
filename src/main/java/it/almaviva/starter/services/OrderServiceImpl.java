package it.almaviva.starter.services;

import it.almaviva.starter.domain.entities.Customer;
import it.almaviva.starter.domain.entities.Order;
import it.almaviva.starter.domain.entities.OrderItem;
import it.almaviva.starter.domain.entities.RetailItem;
import it.almaviva.starter.repositories.CustomerRepository;
import it.almaviva.starter.repositories.OrderItemRepository;
import it.almaviva.starter.repositories.OrderRepository;
import it.almaviva.starter.repositories.RetailItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
        RetailItem retailItem = retailItemRepository.findById(1L).get();
        // retrieve the customer using it's id
        Customer customer = customerRepository.findById(1L).get();
        // create the an order Item
        OrderItem orderItem = new OrderItem(5, retailItem);
        Set<OrderItem> orderItems = new HashSet<>();
        orderItems.add(orderItem);
        orderItemRepository.save(orderItem);
        // creare an order
        Order order = new Order(orderItems, customer);
        return orderRepository.save(order).id;
    }
}
