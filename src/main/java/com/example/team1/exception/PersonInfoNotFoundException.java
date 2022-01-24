package com.example.team1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonInfoNotFoundException extends RuntimeException{

    public PersonInfoNotFoundException(String message) {
        super(message);
    }

    public PersonInfoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
