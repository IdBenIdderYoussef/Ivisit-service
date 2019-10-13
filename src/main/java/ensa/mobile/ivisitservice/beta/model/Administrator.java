package ensa.mobile.ivisitservice.beta.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ensa.mobile.ivisitservice.beta.model.serializer.AccountSerializer;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iv_administrators")
public class Administrator extends AbstractAuditableEntity<Account, Long> {

    @ManyToOne
    @JsonSerialize(using = AccountSerializer.class)
    private Account account;

}
