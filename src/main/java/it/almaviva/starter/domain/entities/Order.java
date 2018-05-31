package it.almaviva.starter.domain.entities;

import it.almaviva.starter.domain.RootEntity;
import it.almaviva.starter.domain.objects.Amount;
import it.almaviva.starter.domain.objects.ShippingAddress;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE)
@ToString(exclude={"orderItems", "customer"})
@EqualsAndHashCode(exclude={"orderItems", "customer"})
@Entity
@Table(name="`order`")
public class Order implements RootEntity<Order> {
    @Id
    @GeneratedValue(generator="optimized-sequence")
    public Long id;

    // an order has a date
    public Date orderDate;

    // an order has a shipping address
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="address", column=@Column(name="shipping_address")),
    })
    public ShippingAddress address;

    // an order has a total price which is paid by the customer
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="price", column=@Column(name="total_price")),
    })
    public Amount totalPrice;

    // an order requires a cost to be shipped to the customer
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="price", column=@Column(name="shipping_cost")),
    })
    public Amount shippingCost;

    // an order is the owner of all order items, so we use OneToMany
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="order_item_id")
    public Set<OrderItem> orderItems;

    // a customer can own multiple orders, so we use ManyToOne
    @ManyToOne(fetch=FetchType.LAZY, cascade={})
    @JoinColumn(name="customer_id")
    public Customer customer;

    public Order(Set<OrderItem> orderItems, Customer customer) {
        this.orderDate = new Date(System.currentTimeMillis());
        this.address = new ShippingAddress();
        this.totalPrice = new Amount();
        this.shippingCost = new Amount();
        this.orderItems = orderItems;
        this.customer = customer;
    }

    public Order(Date orderDate, ShippingAddress address,
                 Amount totalPrice, Amount shippingCost,
                 Set<OrderItem> orderItems, Customer customer) {
        this.orderDate = orderDate;
        this.address = address;
        this.totalPrice = totalPrice;
        this.shippingCost = shippingCost;
        this.orderItems = orderItems;
        this.customer = customer;
    }
}
