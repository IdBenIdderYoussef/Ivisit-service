package ensa.mobile.ivisitservice.beta.model.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDTO {

    private Long id;
    private String firstName;
    private String lastName;

}
