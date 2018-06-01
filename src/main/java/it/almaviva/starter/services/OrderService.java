package it.almaviva.starter.services;

import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Option;
import it.almaviva.starter.domain.jpa.entities.OrderEntity;

public interface OrderService {
    List<OrderEntity> getAllOrders();
    Option<OrderEntity> getSingleOrder(Long orderId);
    OrderEntity insertOrder(Long customerId, String address,
                     List<Tuple2<Integer, Long>> idsAndQuantities);
    void insertOrderItemIntoOrder();
}
