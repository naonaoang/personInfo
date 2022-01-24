package com.example.team1.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDomain {

    private String cellPhone;

    private String workPhone;

    private String email;

    private String workEmail;

}
