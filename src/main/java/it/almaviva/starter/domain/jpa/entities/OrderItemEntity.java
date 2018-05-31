package it.almaviva.starter.domain.jpa.entities;

import it.almaviva.starter.domain.AbstractBaseEntity;
import it.almaviva.starter.domain.description.entities.Order;
import it.almaviva.starter.domain.jpa.objects.AmountObject;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@ToString(exclude={"retailItem"})
@Entity
@Table(name="`order_item`")
public class OrderItemEntity extends AbstractBaseEntity<Order.OrderItem> implements Order.OrderItem {

    // an order item can be ordered many times
    private Integer quantity;

    // an order item has a price which can differ from the retail item
    private AmountObject price;

    // a retail item may be referenced by multiple order items
    @ManyToOne(fetch=FetchType.LAZY, cascade={}, optional=false)
    @JoinColumn(name="retail_item_id")
    private RetailItemEntity retailItem;

    public OrderItemEntity(Integer quantity, RetailItemEntity retailItem) {
        this.quantity = quantity;
        this.price = retailItem.getCurrentPrice();
        this.retailItem = retailItem;
    }

    public OrderItemEntity(Integer quantity, AmountObject price, RetailItemEntity retailItem) {
        this.quantity = quantity;
        this.price = price;
        this.retailItem = retailItem;
    }
}
