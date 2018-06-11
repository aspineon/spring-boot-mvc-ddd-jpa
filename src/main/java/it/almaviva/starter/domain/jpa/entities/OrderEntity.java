package it.almaviva.starter.domain.jpa.entities;

import it.almaviva.starter.domain.AbstractRootEntity;
import it.almaviva.starter.domain.description.entities.Order;
import it.almaviva.starter.domain.jpa.objects.AmountObject;
import it.almaviva.starter.domain.jpa.objects.ShippingAddressObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"orderItems", "customer"})
@Entity
@Table(name = "`order`")
public class OrderEntity extends AbstractRootEntity<Order, OrderEntity>
    implements Order {

    private Date orderDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "shipping_address")),
    })
    @Column(name = "shipping_address")
    private ShippingAddressObject shippingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "price", column = @Column(name = "shipping_cost")),
    })
    @Column(name = "shipping_cost")
    private AmountObject shippingCost;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "`order_order_item`",
        joinColumns = @JoinColumn(name = "order_item_id",
            referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "order_id",
            referencedColumnName = "id"))
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
