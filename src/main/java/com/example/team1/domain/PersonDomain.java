package com.example.team1.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDomain {

    private String firstName;

    private String lastName;

    private String avatar;

    private String dob;

    private String ssn;

}
