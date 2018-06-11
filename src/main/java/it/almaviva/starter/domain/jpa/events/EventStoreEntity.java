package it.almaviva.starter.domain.jpa.events;

import it.almaviva.starter.domain.AbstractBaseEntity;
import it.almaviva.starter.domain.description.events.EventStore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "`customer`")
public class EventStoreEntity extends AbstractBaseEntity<EventStore> implements EventStore {

}
