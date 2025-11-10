package com.example.daweb.RaquelyMiguel.services;

import com.example.daweb.RaquelyMiguel.persistence.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

}
