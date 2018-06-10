package it.almaviva.starter.rest.dto;

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
}
