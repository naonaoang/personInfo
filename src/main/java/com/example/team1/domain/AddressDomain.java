package com.example.team1.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDomain {

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String zipcode;

    private Integer personId;

    private Integer id;
}
