package com.example.team1.domain;

import com.example.team1.entity.Address;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyContactDomain {

    private Integer personId;

    private String name;

    private String phone;

    private String address;

    private String relationship;

    private String title;

    private Integer id;

    private Boolean isReference;

    private Boolean isEmergency;
}
