package it.almaviva.starter.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@Setter(AccessLevel.PRIVATE)
@MappedSuperclass
public abstract class AbstractBaseEntity<T extends BaseEntity<T>>
    implements BaseEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public boolean sameIdentityAs(final T that) {
        return this.equals(that);
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof AbstractBaseEntity)) {
            return false;
        }
        final AbstractBaseEntity<?> that = (AbstractBaseEntity<?>) object;
        checkIdentity(this);
        checkIdentity(that);
        return this.id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    private void checkIdentity(final AbstractBaseEntity<?> entity) {
        if (entity.getId() == null){
            throw new IllegalStateException("Identity missing in entity: " + entity);
        }
    }
}
