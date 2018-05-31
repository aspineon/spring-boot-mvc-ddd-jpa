package it.almaviva.starter.domain.entities;

import it.almaviva.starter.domain.BaseEntity;
import it.almaviva.starter.domain.objects.Amount;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@ToString(exclude={"retailItem"})
@EqualsAndHashCode(exclude={"retailItem"})
@Entity
@Table(name="`order_item`")
public class OrderItem implements BaseEntity<Order> {
    @Id
    @GeneratedValue(generator="optimized-sequence")
    public Long id;

    // an order item can be ordered many times
    public Integer quantity;

    // an order item has a price which can differ from the retail item
    public Amount price;

    // a retail item may be referenced by multiple order items
    @ManyToOne(fetch=FetchType.LAZY, cascade={}, optional=false)
    @JoinColumn(name="retail_item_id")
    public RetailItem retailItem;

    public OrderItem(Integer quantity, RetailItem retailItem) {
        this.quantity = quantity;
        this.price = retailItem.currentPrice;
        this.retailItem = retailItem;
    }

    public OrderItem(Integer quantity, Amount price, RetailItem retailItem) {
        this.quantity = quantity;
        this.price = price;
        this.retailItem = retailItem;
    }
}
