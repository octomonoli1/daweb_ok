package com.example.daweb.LaEliteTest.service;

import com.example.daweb.laElite.persistence.entities.Alumno;
import com.example.daweb.laElite.persistence.repositories.AlumnoRepository;
import com.example.daweb.laElite.services.AlumnoService;
import com.example.daweb.laElite.services.exceptions.AlumnoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest_Create {

    @Mock
    private AlumnoRepository alumnoRepository;

    @InjectMocks
    private AlumnoService alumnoService;

    @Test
    public void create_ok() throws AlumnoException {

        // Given
        Alumno alumno = new Alumno();
        alumno.setId(1);
        alumno.setName("Juan");

        Mockito.when(alumnoRepository.existsById(1)).thenReturn(false);
        Mockito.when(alumnoRepository.save(alumno)).thenReturn(alumno);

        // When
        Alumno result = alumnoService.create(alumno);

        // Then
        assertEquals(alumno, result);
        Mockito.verify(alumnoRepository).save(alumno);
    }

    @Test
    public void create_alumnoAlreadyExists() {

        // Given
        Alumno alumno = new Alumno();
        alumno.setId(1);
        alumno.setName("Juan");

        Mockito.when(alumnoRepository.existsById(1)).thenReturn(true);

        // When - Then
        assertThrows(AlumnoException.class, () -> alumnoService.create(alumno));

        Mockito.verify(alumnoRepository, Mockito.never()).save(Mockito.any());
    }
}
