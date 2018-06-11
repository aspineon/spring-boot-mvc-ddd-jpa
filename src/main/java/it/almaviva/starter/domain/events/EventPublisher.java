package it.almaviva.starter.domain.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public <T> void raiseDomainEvent(T event) {
        applicationEventPublisher.publishEvent(event);
    }
}
