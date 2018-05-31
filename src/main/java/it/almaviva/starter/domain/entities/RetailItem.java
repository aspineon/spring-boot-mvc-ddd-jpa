package it.almaviva.starter.domain.entities;

import it.almaviva.starter.domain.RootEntity;
import it.almaviva.starter.domain.objects.Amount;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@Entity
@Table(name="`retail_item`")
public class RetailItem implements RootEntity<RetailItem> {
    @Id
    @GeneratedValue(generator="optimized-sequence")
    public Long id;

    // a retail item has a title
    public String title;

    // a retail item has a description
    public String description;

    // a retail item has a price which reflect its value on the market
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="price", column=@Column(name="current_price")),
    })
    @Column(name="current_price")
    public Amount currentPrice;

    public RetailItem(String title, String description) {
        this.title = title;
        this.description = description;
        this.currentPrice = new Amount();
    }

    public RetailItem(String title, String description, Amount currentPrice) {
        this.title = title;
        this.description = description;
        this.currentPrice = currentPrice;
    }
}
