package it.almaviva.starter.domain.jpa.entities;

import it.almaviva.starter.domain.AbstractBaseEntity;
import it.almaviva.starter.domain.description.entities.RetailItem;
import it.almaviva.starter.domain.jpa.objects.AmountObject;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@Entity
@Table(name="`retail_item`")
public class RetailItemEntity extends AbstractBaseEntity<RetailItem> implements RetailItem {

    // a retail item has a title
    private String title;

    // a retail item has a description
    private String description;

    // a retail item has a price which reflect its value on the market
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="price", column=@Column(name="current_price")),
    })
    @Column(name="current_price")
    private AmountObject currentPrice;

    public RetailItemEntity(String title, String description) {
        this.title = title;
        this.description = description;
        this.currentPrice = new AmountObject();
    }

    public RetailItemEntity(String title, String description, AmountObject currentPrice) {
        this.title = title;
        this.description = description;
        this.currentPrice = currentPrice;
    }
}
