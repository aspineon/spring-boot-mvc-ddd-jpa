package it.almaviva.starter.domain.description.events;

import it.almaviva.starter.domain.BaseEntity;

import java.sql.Date;

public interface EventStore extends BaseEntity<EventStore> {

    Date getTimestamp();

    Boolean processed();

    String getPayload();
}
