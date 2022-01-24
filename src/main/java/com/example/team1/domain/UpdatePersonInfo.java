package com.example.team1.domain;


import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePersonInfo {

    private Integer id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String preferredName;

    private String avatar;

    private String dob;

    private String gender;

    private String ssn;

    private String driverLicense;

    private String driverLicense_ExpirationDate;
}
