package it.almaviva.starter.services;

import it.almaviva.starter.domain.jpa.entities.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderEntity> getAllOrders();
    Optional<OrderEntity> getSingleOrder(Long orderId);
    void insertOrder();
    void insertOrderItemIntoOrder();
}
