package com.example.team1.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDomain {

    private String visaType;

    private String startDate;

    private String endDate;

    private String visaStartDate;

    private String visaEndDate;

    private String title;

}
