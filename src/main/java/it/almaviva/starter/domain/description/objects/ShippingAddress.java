package it.almaviva.starter.domain.description.objects;

import it.almaviva.starter.domain.BaseObject;

public interface ShippingAddress extends BaseObject<ShippingAddress> {

    String getAddress();
}
