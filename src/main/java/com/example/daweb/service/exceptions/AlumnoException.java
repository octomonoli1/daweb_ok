package com.example.daweb.service.exceptions;

import java.io.Serial;

public class AlumnoException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public AlumnoException(String message){
        super(message);
    }

}


