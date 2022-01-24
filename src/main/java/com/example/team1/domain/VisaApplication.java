package com.example.team1.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class VisaApplication {
    public String currentStatus;
    public String nextStep;
    public boolean showTemplate;
}
