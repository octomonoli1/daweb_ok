package com.example.daweb.EmilioVanesa.service.exceptions;

import java.io.Serial;

public class AlumnoException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public AlumnoException(String message){
        super(message);
    }

}


