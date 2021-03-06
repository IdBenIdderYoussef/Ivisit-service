package ensa.mobile.ivisitservice.beta.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ensa.mobile.ivisitservice.beta.model.serializer.AccountSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity<U, ID> extends AbstractPersistableEntity<ID> implements Serializable {

    @CreatedDate
    LocalDate createdDate;

    @LastModifiedDate
    LocalDate lastModifiedDate;

    @CreatedBy
    @ManyToOne
    @JsonSerialize(using = AccountSerializer.class)
    U createdBy;

    @LastModifiedBy
    @ManyToOne
    @JsonSerialize(using = AccountSerializer.class)
    U lastModifiedBy;
}
