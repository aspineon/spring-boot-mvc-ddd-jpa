package it.almaviva.starter.rest.commands;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = AddOrderItemToOrder.AddOrderItemToOrderBuilder.class)
public final class AddOrderItemToOrder {

    @NonNull
    private Long retailItemId;
    @NonNull
    private Integer quantity;

    @JsonPOJOBuilder(withPrefix = "")
    static final class AddOrderItemToOrderBuilder {
    }
}
