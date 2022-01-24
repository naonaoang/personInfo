package com.example.team1.domain;

import lombok.*;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDocsDomain {

    private String title;

    private String path;

    private String comment;

}
