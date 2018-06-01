package it.almaviva.starter.rest.commands;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import reactor.util.function.Tuple2;

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
    @NonNull
    private List<Tuple2<Long, Integer>> retailItemsWithQuantity;

    @JsonPOJOBuilder(withPrefix="")
    static final class RegisterOrderBuilder {
    }
}