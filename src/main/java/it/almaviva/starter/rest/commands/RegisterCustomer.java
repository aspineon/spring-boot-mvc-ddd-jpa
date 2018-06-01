package it.almaviva.starter.rest.commands;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder=RegisterCustomer.RegisterCustomerBuilder.class)
public final class RegisterCustomer {

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    @JsonPOJOBuilder(withPrefix="")
    static final class RegisterCustomerBuilder {
    }
}
