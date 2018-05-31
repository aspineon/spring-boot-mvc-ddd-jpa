package it.almaviva.starter.domain.entities;

import it.almaviva.starter.domain.RootEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@Entity
@Table(name="`customer`")
public class Customer implements RootEntity<Customer> {
    @Id
    @GeneratedValue(generator="optimized-sequence")
    public Long id;

    // a customer has a name
    public String firstName;

    // a customer has a lst name
    public String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
