package com.example.team1.domain;

import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfoDomain {

    private String firstName;

    private String lastName;

    private String middleName;

    private String avatar;

    private String gender;

    //optional
    private String driverLicense;

    //optional
    private String driverLicenseExpirationDate;

    private String email;

    private String cellPhone;

    private String alternatePhone;

    private EmployeeDomain employment;

    private List<EmergencyContactDomain> contact;

    private List<AddressDomain> addressList;

    private List<PersonalDocsDomain> documentList;

    private Integer id;

    private String dob;

    private String SSN;

}
