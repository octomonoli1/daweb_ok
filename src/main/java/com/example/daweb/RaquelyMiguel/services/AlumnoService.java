package com.example.daweb.RaquelyMiguel.services;

import com.example.daweb.RaquelyMiguel.persistence.repositories.AlumnoRepository;
import com.example.daweb.RaquelyMiguel.services.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public void deleteById(int id) {
        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
    }

}
