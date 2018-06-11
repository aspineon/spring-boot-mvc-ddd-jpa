package it.almaviva.starter.rest.dtos;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import it.almaviva.starter.domain.jpa.entities.OrderEntity;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.sql.Date;

@Value
@Builder
public final class OrderDTO {

    @NonNull
    private Long id;
    @NonNull
    private Date orderDate;
    @NonNull
    private String shippingAddress;
    @NonNull
    private Integer shippingCost;
    @NonNull
    private java.util.Set<OrderItemDTO> orderItems;
    @NonNull
    private Long customerId;

    public static OrderDTO fromOrderEntity(OrderEntity orderEntity) {
        OrderDTOBuilder orderBuilder = OrderDTO.builder();
        Set<OrderItemDTO> orderItemDTOs = HashSet
            .ofAll(orderEntity.getOrderItems())
            .map(OrderItemDTO::fromOrderItemEntity);
        return orderBuilder
            .id(orderEntity.getId())
            .orderDate(orderEntity.getOrderDate())
            .shippingAddress(orderEntity.getShippingAddress().getAddress())
            .shippingCost(orderEntity.getShippingCost().getPrice())
            .orderItems(orderItemDTOs.toJavaSet())
            .customerId(orderEntity.getCustomer().getId())
            .build();
    }
}
