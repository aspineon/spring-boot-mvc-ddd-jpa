package it.almaviva.starter.domain.jpa.objects;

import it.almaviva.starter.domain.description.objects.ShippingAddress;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class ShippingAddressObject implements ShippingAddress {
    private String address;

    public ShippingAddressObject() {
        this.address = "EMPTY_ADDRESS";
    }

    public ShippingAddressObject(String address) {
        this.address = address;
    }
}
