package com.example.daweb.spcajcservice;

import com.example.daweb.spcajc.persistence.entities.Alumno;
import com.example.daweb.spcajc.persistence.repositories.AlumnoRepository;
import com.example.daweb.spcajc.service.AlumnoService;
import com.example.daweb.spcajc.service.exceptions.AlumnoNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {
    @Mock
    private AlumnoRepository alumnoRepository;

    @InjectMocks
    private AlumnoService alumnoService;

    @Test
    public void findByName_Ok(){
        // given
        String name = "Juan";
        List<Alumno> alumnos = List.of(new Alumno());
        Mockito.when(alumnoRepository.findByName(name)).thenReturn(alumnos);

        // When
        List<Alumno> result = alumnoService.findByName(name);

        // Then
        Mockito.verify(alumnoRepository).findByName(name);
        assert(!result.isEmpty());
    }

    @Test
    public void findByName_NotFound(){
        // Given
        String name = "Pepito";
        Mockito.when(alumnoRepository.findByName(name)).thenReturn(List.of());

        // When - Then
        assertThrows(AlumnoNotFoundException.class, () -> alumnoService.findByName(name));
    }
}
