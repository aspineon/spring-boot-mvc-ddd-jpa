package it.almaviva.starter.rest.dtos;

import it.almaviva.starter.domain.jpa.entities.CustomerEntity;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public final class CustomerDTO {

    @NonNull
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    public static CustomerDTO fromCustomerEntity(CustomerEntity customerEntity) {
        CustomerDTOBuilder customerBuilder = CustomerDTO.builder();
        return customerBuilder
            .id(customerEntity.getId())
            .firstName(customerEntity.getFirstName())
            .lastName(customerEntity.getLastName())
            .build();
    }
}
