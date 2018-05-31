package it.almaviva.starter.domain.jpa.objects;

import it.almaviva.starter.domain.description.objects.Amount;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class AmountObject implements Amount {
    private Integer price;

    public AmountObject() {
        this.price = 10;
    }

    public AmountObject(Integer price) {
        this.price = price;
    }
}
