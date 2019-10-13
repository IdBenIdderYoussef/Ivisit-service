package ensa.mobile.ivisitservice.beta.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iv_comments")
public class Comment extends AbstractAuditableEntity<Account ,Long>{

    private String content;
    private int likes;

}
