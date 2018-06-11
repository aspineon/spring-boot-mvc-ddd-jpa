package it.almaviva.starter.rest.controllers;

import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Option;
import it.almaviva.starter.domain.jpa.entities.OrderEntity;
import it.almaviva.starter.rest.commands.AddOrderItemToOrder;
import it.almaviva.starter.rest.commands.RegisterOrder;
import it.almaviva.starter.rest.dtos.OrderDTO;
import it.almaviva.starter.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public ResponseEntity<?> fetchAllOrders() {
        List<OrderEntity> allOrders = orderService.getAllOrders();
        List<OrderDTO> allOrdersDTO = allOrders.map(OrderDTO::fromOrderEntity);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(allOrdersDTO.asJava());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> fetchSingleOrder(@PathVariable Long orderId) {
        Option<OrderEntity> maybeOrder = orderService.getSingleOrder(orderId);
        return maybeOrder
                .map(OrderDTO::fromOrderEntity)
                .map(orderDTO -> ResponseEntity.status(HttpStatus.OK).body(orderDTO))
                .getOrElse(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(value = "", consumes = {"application/json"})
    public ResponseEntity<?> registerOrder(@RequestBody RegisterOrder command) {
        Long customerId = command.getCustomerId();
        String address = command.getAddress();
        List<Tuple2<Integer, Long>> quantitiesAndIds = List.ofAll(command.getSelectedRetailItems())
                .map(selectedRetailItem -> new Tuple2<>(
                        selectedRetailItem.getQuantity(),
                        selectedRetailItem.getRetailItemId())
                );
        OrderEntity insertedOrder = orderService.insertOrder(customerId, address, quantitiesAndIds);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(OrderDTO.fromOrderEntity(insertedOrder));
    }

    @PostMapping(value = "/{orderId}", consumes = "application/json")
    public ResponseEntity<?> addOrderItemToOrder(@PathVariable Long orderId, @RequestBody AddOrderItemToOrder command) {
        Long retailItemId = command.getRetailItemId();
        Integer quantity = command.getQuantity();
        OrderEntity updatedOrder = orderService.insertOrderItemIntoOrder(orderId, retailItemId, quantity);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(OrderDTO.fromOrderEntity(updatedOrder));
    }
}
