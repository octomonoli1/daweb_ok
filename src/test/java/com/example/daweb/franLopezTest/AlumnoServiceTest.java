package com.example.daweb.franLopezTest;

import com.example.daweb.franLopez.entities.Alumno;
import com.example.daweb.franLopez.repositories.AlumnoRepository;
import com.example.daweb.franLopez.services.AlumnoService;
import com.example.daweb.franLopez.services.exceptions.AlumnoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {

    @Mock
    private AlumnoRepository alumnoRepository;

    @InjectMocks
    private AlumnoService alumnoService;

    // ===================== TEST POSITIVO =====================
    @Test
    public void createAlumno_ok() {

        // Given
        Alumno alumno = new Alumno();
        alumno.setName("Juan");
        alumno.setSurname("Pérez");
        alumno.setBirth(LocalDate.of(2005, 2, 23));

        // Simular que el repositorio lo guarda y devuelve el objeto con ID = 1
        Alumno alumnoGuardado = new Alumno();
        alumnoGuardado.setId(1);
        alumnoGuardado.setName("Juan");
        alumnoGuardado.setSurname("Pérez");
        alumnoGuardado.setBirth(alumno.getBirth());

        Mockito.when(alumnoRepository.save(alumno)).thenReturn(alumnoGuardado);

        // When
        Alumno result = alumnoService.createAlumno(alumno);

        // Then
        assertEquals(1, result.getId());
        Mockito.verify(alumnoRepository).save(alumno);
    }

    // ===================== TEST NEGATIVO: nombre vacío =====================
    @Test
    public void createAlumno_nombreVacio_throwException() {

        // Given
        Alumno alumno = new Alumno();
        alumno.setSurname("Pérez");
        alumno.setBirth(LocalDate.of(2005, 2, 23));

        // When - Then
        assertThrows(AlumnoException.class, () -> alumnoService.createAlumno(alumno));
    }

    // ===================== TEST NEGATIVO: apellido vacío =====================
    @Test
    public void createAlumno_apellidoVacio_throwException() {

        // Given
        Alumno alumno = new Alumno();
        alumno.setName("Juan");
        alumno.setBirth(LocalDate.of(2005, 2, 23));

        // When - Then
        assertThrows(AlumnoException.class, () -> alumnoService.createAlumno(alumno));
    }

    // ===================== TEST NEGATIVO: fecha de nacimiento futura =====================
    @Test
    public void createAlumno_fechaFutura_throwException() {

        // Given
        Alumno alumno = new Alumno();
        alumno.setName("Juan");
        alumno.setSurname("Pérez");
        alumno.setBirth(LocalDate.now().plusDays(1));

        // When - Then
        assertThrows(AlumnoException.class, () -> alumnoService.createAlumno(alumno));
    }

    // ===================== TEST NEGATIVO: fecha nula =====================
    @Test
    public void createAlumno_fechaNula_throwException() {

        // Given
        Alumno alumno = new Alumno();
        alumno.setName("Juan");
        alumno.setSurname("Pérez");

        // When - Then
        assertThrows(AlumnoException.class, () -> alumnoService.createAlumno(alumno));
    }

}
