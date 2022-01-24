package com.example.team1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UploadFileResponse {

    private String fileName;
    private String path;//path in db
    //private String comment;
    private String fileType;
    private long size;
}
