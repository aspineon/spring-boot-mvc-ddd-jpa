package it.almaviva.starter.domain.description.entities;

import it.almaviva.starter.domain.BaseEntity;
import it.almaviva.starter.domain.description.objects.Amount;
import it.almaviva.starter.domain.description.objects.ShippingAddress;

import java.sql.Date;
import java.util.Collection;

public interface Order extends BaseEntity<Order> {

    Date getOrderDate();

    ShippingAddress getShippingAddress();

    Amount getShippingCost();

    Collection<? extends OrderItem> getOrderItems();

    Customer getCustomer();

    public static interface OrderItem extends BaseEntity<OrderItem> {

        Integer getQuantity();

        Amount getPrice();

        RetailItem getRetailItem();
    }
}
