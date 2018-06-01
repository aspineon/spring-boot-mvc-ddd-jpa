package it.almaviva.starter.rest.commands;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=RegisterCustomer.RegisterCustomerBuilder.class)
public final class RegisterOrder {

    @NonNull
    private Long customerId;
    @NonNull
    private String address;

    // we need a list of retailItemId and quantity
    @NonNull
    private List<RetailItemIdWithQuantity> retailItemIdsWithQuantity;

    @JsonPOJOBuilder(withPrefix="")
    static final class RegisterOrderBuilder {
    }
}

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=RegisterCustomer.RegisterCustomerBuilder.class)
final class RetailItemIdWithQuantity {
    private Long retailItemId;
    private Integer quantity;
}
