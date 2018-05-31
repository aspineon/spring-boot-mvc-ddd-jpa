package it.almaviva.starter.domain.jpa.entities;

import it.almaviva.starter.domain.AbstractBaseEntity;
import it.almaviva.starter.domain.description.entities.Order;
import it.almaviva.starter.domain.description.objects.Amount;
import it.almaviva.starter.domain.description.objects.ShippingAddress;
import it.almaviva.starter.domain.jpa.objects.AmountObject;
import it.almaviva.starter.domain.jpa.objects.ShippingAddressObject;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@ToString(exclude={"orderItems", "customer"})
@Entity
@Table(name="`order`")
public class OrderEntity extends AbstractBaseEntity<Order> {

    // an order has a date
    private Date orderDate;

    // an order has a shipping address
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="address", column=@Column(name="shipping_address")),
    })
    private ShippingAddress address;

    // an order has a total price which is paid by the customer
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="price", column=@Column(name="total_price")),
    })
    private Amount totalPrice;

    // an order requires a cost to be shipped to the customer
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="price", column=@Column(name="shipping_cost")),
    })
    private Amount shippingCost;

    // an order is the owner of all order items, so we use OneToMany
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="order_item_id")
    private Set<OrderItemEntity> orderItems;

    // a customer can own multiple orders, so we use ManyToOne
    @ManyToOne(fetch=FetchType.LAZY, cascade={})
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;

    public OrderEntity(Set<OrderItemEntity> orderItems, CustomerEntity customer) {
        this.orderDate = new Date(System.currentTimeMillis());
        this.address = new ShippingAddressObject();
        this.totalPrice = new AmountObject();
        this.shippingCost = new AmountObject();
        this.orderItems = orderItems;
        this.customer = customer;
    }

    public OrderEntity(Date orderDate, ShippingAddress address,
                       Amount totalPrice, Amount shippingCost,
                       Set<OrderItemEntity> orderItems, CustomerEntity customer) {
        this.orderDate = orderDate;
        this.address = address;
        this.totalPrice = totalPrice;
        this.shippingCost = shippingCost;
        this.orderItems = orderItems;
        this.customer = customer;
    }
}
