package ensa.mobile.ivisitservice.beta.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iv_posts")
public class Post extends AbstractAuditableEntity<Account , Long>{

    private String title;
    private String description;
    private String picture;
    private int likes;

    @Embedded
    private Address address;

}
