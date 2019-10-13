package ensa.mobile.ivisitservice.beta.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iv_reports")
public class Report extends AbstractAuditableEntity<Account ,Long>{

    private String reason;
    private String description;


}
