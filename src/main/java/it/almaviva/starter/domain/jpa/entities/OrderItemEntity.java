package it.almaviva.starter.domain.jpa.entities;

import it.almaviva.starter.domain.AbstractBaseEntity;
import it.almaviva.starter.domain.description.entities.Order;
import it.almaviva.starter.domain.jpa.objects.AmountObject;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"retailItem"})
@Entity
@Table(name = "`order_item`")
public class OrderItemEntity extends AbstractBaseEntity<Order.OrderItem>
    implements Order.OrderItem {

    private Integer quantity;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "price", column = @Column(name = "price")),
    })
    @Column(name = "price")
    private AmountObject price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {}, optional = false)
    @JoinColumn(name= "retail_item_id")
    private RetailItemEntity retailItem;

    public OrderItemEntity(Integer quantity, RetailItemEntity retailItem) {
        this.quantity = quantity;
        this.price = retailItem.getCurrentPrice();
        this.retailItem = retailItem;
    }

    public OrderItemEntity(Integer quantity, Integer price, RetailItemEntity retailItem) {
        this.quantity = quantity;
        this.price = new AmountObject(price);
        this.retailItem = retailItem;
    }
}
