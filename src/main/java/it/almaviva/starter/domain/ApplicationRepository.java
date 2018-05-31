package it.almaviva.starter.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class ApplicationRepository<R extends RootEntity<R>> implements CrudRepository<R, Long> {

    public Optional<R> findByAssociation(Association<R> assoc) {
        return findById(assoc.getId());
    }
}
