package com.example.daweb.laElite.services;

import com.example.daweb.laElite.persistence.entities.Alumno;
import com.example.daweb.laElite.persistence.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    private Alumno create(Alumno alumno){
        return alumnoRepository.save(alumno);
    }
}
