package com.example.daweb.RaquelyMiguel.service;

import com.example.daweb.RaquelyMiguel.persistence.repositories.AlumnoRepository;
import com.example.daweb.RaquelyMiguel.services.AlumnoService;
import com.example.daweb.RaquelyMiguel.services.exceptions.AlumnoNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {

    @Mock
    private AlumnoRepository alumnoRepository;

    @InjectMocks
    private AlumnoService alumnoService;

    @Test
    public void deleteById_ok(){

        //Given
        int id = 0;
        Mockito.when(alumnoRepository.existsById(id)).thenReturn(true);

        //When
        this.alumnoService.deleteById(id);

        //Then
        Mockito.verify(alumnoRepository).deleteById(id);

    }

    @Test
    public void deleteById_uerNotExists(){
        //Given
        int id = 0;
        Mockito.when(alumnoRepository.existsById(id)).thenReturn(false);

        //When - then
        assertThrows(AlumnoNotFoundException.class, () -> alumnoService.deleteById(id));
    }

}
