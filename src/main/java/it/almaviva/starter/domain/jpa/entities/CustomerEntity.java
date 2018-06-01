package it.almaviva.starter.domain.jpa.entities;

import it.almaviva.starter.domain.AbstractBaseEntity;
import it.almaviva.starter.domain.description.entities.Customer;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@Entity
@Table(name="`customer`")
public class CustomerEntity extends AbstractBaseEntity<Customer> implements Customer {

    private String firstName;

    private String lastName;

    public CustomerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
