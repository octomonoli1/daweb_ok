package com.example.daweb.FranyAlvaro.services;

import com.example.daweb.FranyAlvaro.persistance.repositories.AlumnoRepository;
import com.example.daweb.FranyAlvaro.services.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("alumnoServiceFranyAlvaro")
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

