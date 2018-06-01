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
@JsonDeserialize(builder = RegisterOrder.RegisterOrderBuilder.class)
public final class RegisterOrder {

    @NonNull
    private Long customerId;
    @NonNull
    private String address;
    @NonNull
    private List<SelectedRetailItem> selectedRetailItems;

    @JsonPOJOBuilder(withPrefix = "")
    static final class RegisterOrderBuilder {
    }

    @Value
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonDeserialize(builder = SelectedRetailItem.SelectedRetailItemBuilder.class)
    public static final class SelectedRetailItem {

        @NonNull
        private Long retailItemId;
        @NonNull
        private Integer quantity;

        @JsonPOJOBuilder(withPrefix = "")
        static final class SelectedRetailItemBuilder {
        }
    }
}
