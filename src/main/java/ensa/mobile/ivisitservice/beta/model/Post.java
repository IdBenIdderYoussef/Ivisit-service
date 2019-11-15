package ensa.mobile.ivisitservice.beta.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(columnDefinition = "LONGBLOB")
    private String picture;

    @Embedded
    private Address address;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "post")
    private List<Comment> comments = new ArrayList<Comment>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "post")
    private List<Like> likes = new ArrayList<Like>();


    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "post")
    private List<Report> reports = new ArrayList<Report>();


}
