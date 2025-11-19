package com.example.daweb.EmilioVanesa.service.exceptions;


import java.io.Serial;

public class AlumnoNotFoundException extends RuntimeException {

        @Serial
        private static final long serialVersionUID = 1L;

        public AlumnoNotFoundException(String message){
            super(message);
        }

    }
