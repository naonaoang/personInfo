package com.example.team1.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "Email")
    private String email;

    @Column(name = "CellPhone")
    private String cellPhone;

    @Column(name = "AlternatePhone")
    private String alternatePhone;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "SSN")
    private String ssn;

    @Column(name = "DOB")
    private String DOB;

    @Column(name = "UserID")
    private Integer userId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.MERGE)
    private List<Address> addressList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<Contact> contact;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
    private VisaStatus visaStatus;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
    private Employee employee;

}
