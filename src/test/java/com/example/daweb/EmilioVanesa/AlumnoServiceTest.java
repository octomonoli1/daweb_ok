package com.example.daweb.EmilioVanesa;

import com.example.daweb.EmilioVanesa.persistence.entities.Alumno;
import com.example.daweb.EmilioVanesa.persistence.repositories.AlumnoRepository;
import com.example.daweb.EmilioVanesa.service.AlumnoService;
import com.example.daweb.EmilioVanesa.service.exceptions.AlumnoNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import java.util.List;

public class AlumnoServiceTest {


    @ExtendWith(MockitoExtension.class)

        @Mock
        private AlumnoRepository alumnoRepository;

        @InjectMocks
        private AlumnoService alumnoService;

        @Test
        public void findById_ok() {

            //Given
            int id = 1;
            Alumno alumno = new Alumno();
            alumno.setId(id);
            alumno.setName("Juan");
            alumno.setSurname("Perez");
            alumno.setFechaNacimiento(LocalDate.of(2000, 1, 1));

            Mockito.when(alumnoRepository.existsById(id)).thenReturn(true);
            Mockito.when(alumnoRepository.findById(id)).thenReturn(List.of(alumno));

            //When
            List<Alumno> result = alumnoService.findById(id);

            //Then
            Mockito.verify(alumnoRepository).existsById(id);
            Mockito.verify(alumnoRepository).findById(id);

            assert(result.size() == 1);
            assert(result.get(0).getName().equals("Juan"));
        }

        @Test
        public void findById_alumnoNotFound(){
            //Given
            int id = 2;
            Mockito.when(alumnoRepository.existsById(id)).thenReturn(false);

            //When - Then
            assertThrows(AlumnoNotFoundException.class, () -> alumnoService.findById(id));

            Mockito.verify(alumnoRepository).existsById(id);
            Mockito.verify(alumnoRepository, Mockito.never()).findById(id);
        }
    }


