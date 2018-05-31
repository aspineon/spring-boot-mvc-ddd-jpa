package it.almaviva.starter.domain;

public interface BaseEntity<T extends BaseEntity<T>> {

    Long getId();

    boolean sameIdentityAs(T that);
}
