package it.almaviva.starter.rest.dto;

import it.almaviva.starter.domain.jpa.entities.OrderEntity;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.sql.Date;
import java.util.Set;

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
    private Set<OrderItemDTO> orderItems;
    @NonNull
    private Long customerId;

    public static OrderDTO fromOrderEntity(OrderEntity orderEntity) {
        return null;
    }
}
