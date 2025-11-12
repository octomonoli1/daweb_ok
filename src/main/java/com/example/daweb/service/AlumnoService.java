package com.example.daweb.service;

import com.example.daweb.persistence.entities.Alumno;
import com.example.daweb.persistence.repositories.AlumnoRepository;
import com.example.daweb.service.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;
    public List<Alumno> findById(int id) {
        if (this.alumnoRepository.existsById(id)) {
            return this.alumnoRepository.findById(id);
        }else {
            throw new AlumnoNotFoundException("No se encuentra el alumno asignado");
        }
    }
}
