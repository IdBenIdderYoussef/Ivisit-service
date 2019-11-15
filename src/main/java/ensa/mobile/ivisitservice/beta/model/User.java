package ensa.mobile.ivisitservice.beta.model;


import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iv_users")
public class User extends AbstractAuditableEntity<Account , Long>{

    private String firstName;
    private String lastName;
    private String picture;



    @OneToOne
    private Account account;

}
