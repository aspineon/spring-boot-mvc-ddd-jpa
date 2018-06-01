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
@JsonDeserialize(builder = RegisterRetailItem.RegisterRetailItemBuilder.class)
public final class RegisterRetailItem {

    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private Integer price;

    @JsonPOJOBuilder(withPrefix = "")
    static final class RegisterRetailItemBuilder {
    }
}
