package com.example.daweb.franLopez.services;

import com.example.daweb.franLopez.entities.Alumno;
import com.example.daweb.franLopez.repositories.AlumnoRepository;
import com.example.daweb.franLopez.services.exceptions.AlumnoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno createAlumno(Alumno alumno) {

        if (alumno.getName() == null || alumno.getName().trim().isEmpty()) {
            throw new AlumnoException("El nombre del alumno no puede estar vacío.");
        }

        if (alumno.getSurname() == null || alumno.getSurname().trim().isEmpty()) {
            throw new AlumnoException("El apellido del alumno no puede estar vacío.");
        }

        if (alumno.getBirth() == null) {
            throw new AlumnoException("La fecha de nacimiento es obligatoria.");
        }

        if (alumno.getBirth().isAfter(LocalDate.now())) {
            throw new AlumnoException("La fecha de nacimiento debe ser anterior a la fecha actual.");
        }

        return alumnoRepository.save(alumno);
    }
}
