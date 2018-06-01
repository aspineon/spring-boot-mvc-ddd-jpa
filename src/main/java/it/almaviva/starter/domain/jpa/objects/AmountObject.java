package it.almaviva.starter.domain.jpa.objects;

import it.almaviva.starter.domain.description.objects.Amount;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@Embeddable
public class AmountObject implements Amount {
    private Integer price;

    public AmountObject(Integer price) {
        this.price = price;
    }
}
