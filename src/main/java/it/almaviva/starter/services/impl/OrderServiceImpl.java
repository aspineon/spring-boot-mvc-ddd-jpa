package it.almaviva.starter.services.impl;

import io.vavr.Tuple2;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import it.almaviva.starter.domain.events.EventPublisher;
import it.almaviva.starter.domain.events.TestEvent;
import it.almaviva.starter.domain.jpa.entities.CustomerEntity;
import it.almaviva.starter.domain.jpa.entities.OrderEntity;
import it.almaviva.starter.domain.jpa.entities.OrderItemEntity;
import it.almaviva.starter.domain.jpa.entities.RetailItemEntity;
import it.almaviva.starter.repositories.CustomerRepository;
import it.almaviva.starter.repositories.OrderItemRepository;
import it.almaviva.starter.repositories.OrderRepository;
import it.almaviva.starter.repositories.RetailItemRepository;
import it.almaviva.starter.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

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
    @Autowired
    private EventPublisher eventPublisher;

    @Transactional
    public List<OrderEntity> getAllOrders() {
        Iterable<OrderEntity> orders = orderRepository.findAll();
        return List.ofAll(orders);
    }

    @Transactional
    public Option<OrderEntity> getSingleOrder(Long orderId) {
        return Option.ofOptional(orderRepository.findById(orderId));
    }

    @Transactional
    public OrderEntity insertOrder(Long customerId, String address,
                                   List<Tuple2<Integer, Long>> quantitiesAndIds) {
        Option<CustomerEntity> customer = Option.ofOptional(
            customerRepository.findById(customerId));
        List<RetailItemEntity> retailItems = List.ofAll(
            retailItemRepository.findAllById(quantitiesAndIds.map(quantityAndId ->
                quantityAndId._2).asJava()));
        List<Tuple2<Integer, RetailItemEntity>> quantitiesAndRetailItems =
            quantitiesAndIds.zipWith(
                retailItems,
                (quantityAndId, retailItemEntity) ->
                    new Tuple2<>(quantityAndId._1, retailItemEntity));
        Set<OrderItemEntity> orderItems = HashSet.ofAll(
            quantitiesAndRetailItems.map(quantityAndRetailItem ->
                new OrderItemEntity(quantityAndRetailItem._1, quantityAndRetailItem._2)));
        OrderEntity order = new OrderEntity(address, orderItems.toJavaSet(), customer.get());
        eventPublisher.raiseDomainEvent(new TestEvent());
        return orderRepository.save(order);
    }

    @Transactional
    public OrderEntity insertOrderItemIntoOrder(Long orderId, Long retailItemId, Integer quantity) {
        Option<OrderEntity> order = Option.ofOptional(orderRepository.findById(orderId));
        Option<RetailItemEntity> retailItem = Option.ofOptional(retailItemRepository.findById(retailItemId));
        Option<OrderItemEntity> orderItem = retailItem.map(ri -> new OrderItemEntity(quantity, ri));
        Option<OrderEntity> maybeUpdatedOrder = orderItem
            .flatMap(oi -> order.map(o -> {
                Set<OrderItemEntity> oldOrderItems = HashSet.ofAll(o.getOrderItems());
                o.setOrderItems(oldOrderItems.add(oi).toJavaSet());
                return orderRepository.save(o);
            }));
        return maybeUpdatedOrder.get();
    }

    @Async
    @TransactionalEventListener
    public void processTestEvent(TestEvent testEvent) {
        System.out.println(testEvent.toString());
    }

}
