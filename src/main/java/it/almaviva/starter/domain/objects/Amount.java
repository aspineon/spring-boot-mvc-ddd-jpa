package it.almaviva.starter.domain.objects;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Amount {
    public Integer price;

    public Amount() {
        this.price = 10;
    }

    public Amount(Integer price) {
        this.price = price;
    }
}
