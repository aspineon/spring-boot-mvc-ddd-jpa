package it.almaviva.starter.rest.dtos;

import it.almaviva.starter.domain.jpa.entities.OrderItemEntity;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public final class OrderItemDTO {

    @NonNull
    private Long id;
    @NonNull
    private Integer quantity;
    @NonNull
    private Integer price;
    @NonNull
    private Long retailItemId;

    public static OrderItemDTO fromOrderItemEntity(OrderItemEntity orderItemEntity) {
        OrderItemDTOBuilder orderItemBuilder = OrderItemDTO.builder();
        return orderItemBuilder
            .id(orderItemEntity.getId())
            .quantity(orderItemEntity.getQuantity())
            .price(orderItemEntity.getPrice().getPrice())
            .retailItemId(orderItemEntity.getRetailItem().getId())
            .build();
    }
}
