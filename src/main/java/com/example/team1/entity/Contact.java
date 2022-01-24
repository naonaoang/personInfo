package com.example.team1.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Relationship")
    private String relationship;

    @Column(name = "Title")
    private String title;

    @Column(name = "isReference")
    private Boolean isReference;

    @Column(name = "isEmergency")
    private Boolean isEmergency;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;


}

