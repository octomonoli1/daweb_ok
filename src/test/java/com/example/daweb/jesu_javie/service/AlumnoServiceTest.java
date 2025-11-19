package com.example.daweb.jesu_javie.service;

import com.example.daweb.jesu_javie.persistence.entities.Alumno;
import com.example.daweb.jesu_javie.persistence.repositories.AlumnoRepository;
import com.example.daweb.jesu_javie.services.AlumnoService;
import com.example.daweb.jesu_javie.services.exceptions.AlumnoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {

    @Mock
    private AlumnoRepository alumnoRepository;

    @InjectMocks
    private AlumnoService alumnoService;

    @Test
    void create_ok() {
        Alumno input = new Alumno();
        input.setName("Álvaro");

        Alumno saved = new Alumno();
        saved.setName("Álvaro");

        Mockito.when(alumnoRepository.save(input)).thenReturn(saved);

        Alumno result = alumnoService.create(input);

        assertEquals("Álvaro", result.getName());
        Mockito.verify(alumnoRepository).save(input);
    }

    @Test
    void create_NameIsEmpty() {
        Alumno input = new Alumno();
        input.setName("");

        assertThrows(AlumnoException.class, () -> alumnoService.create(input));
        Mockito.verify(alumnoRepository, Mockito.never()).save(Mockito.any());
    }

    @Test
    void create_NameIsNull() {
        Alumno input = new Alumno();
        input.setName(null);

        assertThrows(AlumnoException.class, () -> alumnoService.create(input));
        Mockito.verify(alumnoRepository, Mockito.never()).save(Mockito.any());
    }
}
