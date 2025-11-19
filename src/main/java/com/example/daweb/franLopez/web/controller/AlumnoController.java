package com.example.daweb.franLopez.web.controller;

import com.example.daweb.franLopez.entities.Alumno;
import com.example.daweb.franLopez.services.AlumnoService;
import com.example.daweb.franLopez.services.exceptions.AlumnoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/create")
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno) {
        try {
            Alumno nuevoAlumno = alumnoService.createAlumno(alumno);
    //comentario
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Alumno creado correctamente con ID: " + nuevoAlumno.getId());

        } catch (AlumnoException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el alumno: " + ex.getMessage());
        }
    }
}
