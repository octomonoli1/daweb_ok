package com.example.daweb.franLopezTest;

import com.example.daweb.franLopez.entities.Alumno;
import com.example.daweb.franLopez.services.AlumnoService;
import com.example.daweb.franLopez.services.exceptions.AlumnoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.daweb.franLopez.web.controller.AlumnoController;


import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlumnoController.class)
class AlumnoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlumnoService alumnoService;

    // ObjectMapper configurado para LocalDate
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        // Registrar módulo para soporte de java.time (LocalDate) y desactivar timestamps
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    // ===== TEST POSITIVO =====
    @Test
    void createAlumno_ok() throws Exception {
        Alumno alumno = new Alumno();
        alumno.setId(1);
        alumno.setName("Juan");
        alumno.setSurname("Pérez");
        alumno.setBirth(LocalDate.of(2005, 2, 23));

        Mockito.when(alumnoService.createAlumno(any(Alumno.class))).thenReturn(alumno);

        mockMvc.perform(post("/alumno/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(alumno)))
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString("Alumno creado correctamente")))
                .andExpect(content().string(containsString("1")));
    }

    // ===== TEST NEGATIVO: nombre vacío =====
    @Test
    void createAlumno_nombreVacio_badRequest() throws Exception {
        Alumno alumno = new Alumno();
        alumno.setSurname("Pérez");
        alumno.setBirth(LocalDate.of(2005, 2, 23));

        Mockito.when(alumnoService.createAlumno(any(Alumno.class)))
                .thenThrow(new AlumnoException("El nombre del alumno no puede estar vacío."));

        mockMvc.perform(post("/alumno/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(alumno)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("El nombre del alumno no puede estar vacío")));
    }

    // ===== TEST NEGATIVO: fecha de nacimiento futura =====
    @Test
    void createAlumno_fechaFutura_badRequest() throws Exception {
        Alumno alumno = new Alumno();
        alumno.setName("Juan");
        alumno.setSurname("Pérez");
        alumno.setBirth(LocalDate.now().plusDays(1));

        Mockito.when(alumnoService.createAlumno(any(Alumno.class)))
                .thenThrow(new AlumnoException("La fecha de nacimiento debe ser anterior a la fecha actual."));

        mockMvc.perform(post("/alumno/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(alumno)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("La fecha de nacimiento debe ser anterior a la fecha actual")));
    }

    // ===== TEST NEGATIVO: error inesperado del servidor =====
    @Test
    void createAlumno_errorServidor_internalError() throws Exception {
        Alumno alumno = new Alumno();
        alumno.setName("Juan");
        alumno.setSurname("Pérez");
        alumno.setBirth(LocalDate.of(2005, 2, 23));

        Mockito.when(alumnoService.createAlumno(any(Alumno.class)))
                .thenThrow(new RuntimeException("Fallo raro"));

        mockMvc.perform(post("/alumno/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(alumno)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string(containsString("Error al crear el alumno")));
    }
}
