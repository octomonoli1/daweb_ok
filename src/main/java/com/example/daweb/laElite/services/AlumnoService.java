package com.example.daweb.laElite.services;

import com.example.daweb.laElite.persistence.entities.Alumno;
import com.example.daweb.laElite.persistence.repositories.AlumnoRepository;
import com.example.daweb.laElite.services.exceptions.AlumnoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno create(Alumno alumno){
        if (alumnoRepository.existsById(alumno.getId())) {
            throw new AlumnoException("Alumno ya existe");
        }
        return alumnoRepository.save(alumno);
    }
}
