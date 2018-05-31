package it.almaviva.starter.domain.objects;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class ShippingAddress {
    public String address;

    public ShippingAddress() {
        this.address = "EMPTY_ADDRESS";
    }

    public ShippingAddress(String address) {
        this.address = address;
    }
}
