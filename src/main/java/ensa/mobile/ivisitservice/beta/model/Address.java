package ensa.mobile.ivisitservice.beta.model;


import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address{

    private String country;
    private String city;

}
