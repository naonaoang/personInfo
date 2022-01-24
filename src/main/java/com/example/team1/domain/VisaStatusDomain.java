package com.example.team1.domain;

import lombok.*;
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisaStatusDomain {

    private String visaType;

    private Boolean isActive;

}
