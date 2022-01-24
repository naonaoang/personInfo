package com.example.team1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="VisaStatus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  VisaStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "VisaType")
    private String visaType;

    @Column(name = "Active")
    private Boolean active;

    @OneToOne
    @JoinColumn(name = "CreateUser")
    private Person person;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "visaStatus")
    private Employee employee;

}
