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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = {"orderItems", "customer"})
@Entity
@Table(name = "`order`")
public class OrderEntity extends AbstractBaseEntity<Order> implements Order {

    private Date orderDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "shipping_address")),
    })
    private ShippingAddress shippingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "price", column = @Column(name = "shipping_cost")),
    })
    private Amount shippingCost;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<OrderItemEntity> orderItems;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {}, optional = false)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    public OrderEntity(String address, Set<OrderItemEntity> orderItems, CustomerEntity customer) {
        this.orderDate = new Date(System.currentTimeMillis());
        this.shippingAddress = new ShippingAddressObject(address);
        this.shippingCost = new AmountObject(0);
        this.orderItems = orderItems;
        this.customer = customer;
    }
}
