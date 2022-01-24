package com.example.team1.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "PersonID")
    private Person person;

    @Column(name = "Title")
    private String title;

    @Column(name = "ManagerID")
    private Integer managerId;

    @Column(name = "StartDate")
    private String startDate;

    @Column(name = "EndDate")
    private String endDate;

    @Column(name = "Avatar")
    private String avatar;

    @Column(name = "Car")
    private String car;

    @OneToOne
    @JoinColumn(name = "VisaStatusID")
    private VisaStatus visaStatus;

    @Column(name = "VisaStartDate")
    private String visaStartDate;

    @Column(name = "VisaEndDate")
    private String visaEndDate;

    @Column(name = "DriverLicense")
    private String driverLicense;

    @Column(name = "DriverLicense_ExpirationDate")
    private String driverLicenseExpirationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade = CascadeType.MERGE)
    private List<PersonalDocument> personalDocuments;
}
