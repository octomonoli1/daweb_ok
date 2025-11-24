package com.example.daweb.jesu_javie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.daweb.jesu_javie.persistence.entities.Alumno;
import com.example.daweb.jesu_javie.persistence.repositories.AlumnoRepository;
import com.example.daweb.jesu_javie.services.exceptions.AlumnoException;
import com.example.daweb.jesu_javie.services.exceptions.AlumnoNotFoundException;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    // create
    public Alumno create(Alumno alumno) {
        if (alumno.getName() == null || alumno.getName().isEmpty()) {
            throw new AlumnoException("El nombre es obligatorio");
        }
        return alumnoRepository.save(alumno);
    }
/*
    // findByID
    public Alumno findById(int id) {
        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException("El ID " + id + " no existe");
        }
        return alumnoRepository.findById(id).get();
    }

    // update
    public Alumno update(int id, Alumno alumnoBody) {
        Alumno alumnoExistente = findById(id);

        if (!alumnoExistente.getSurname().equals(alumnoBody.getSurname())) {
            throw new AlumnoException("No se puede modificar el apellido");
        }

        if (!alumnoExistente.getBirth().equals(alumnoBody.getBirth())) {
            throw new AlumnoException("No se puede modificar la fecha de nacimiento");
        }

        alumnoExistente.setName(alumnoBody.getName());
        return alumnoRepository.save(alumnoExistente);
    }

    // delete
    public void delete(int id) {
        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException("El ID " + id + " no existe, no se puede borrar");
        }
        alumnoRepository.deleteById(id);
    }*/
}