package it.almaviva.starter.domain.jpa.objects;

import it.almaviva.starter.domain.description.objects.ShippingAddress;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@Embeddable
public class ShippingAddressObject implements ShippingAddress {
    private String address;

    public ShippingAddressObject(String address) {
        this.address = address;
    }
}
