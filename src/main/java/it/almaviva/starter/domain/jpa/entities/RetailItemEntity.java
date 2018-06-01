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

    private String title;

    private String description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="price", column=@Column(name="current_price")),
    })
    @Column(name="current_price")
    private AmountObject currentPrice;

    public RetailItemEntity(String title, String description) {
        this.title = title;
        this.description = description;
        this.currentPrice = new AmountObject(0);
    }

    public RetailItemEntity(String title, String description, Integer price) {
        this.title = title;
        this.description = description;
        this.currentPrice = new AmountObject(price);
    }
}
