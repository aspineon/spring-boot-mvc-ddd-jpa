package it.almaviva.starter.domain.jpa.entities;

import it.almaviva.starter.domain.AbstractRootEntity;
import it.almaviva.starter.domain.description.entities.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "`customer`")
public class CustomerEntity extends AbstractRootEntity<Customer, CustomerEntity>
    implements Customer {

    private String firstName;

    private String lastName;

    public CustomerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
