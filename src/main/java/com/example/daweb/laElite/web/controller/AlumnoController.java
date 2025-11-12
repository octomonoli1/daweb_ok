package com.example.daweb.laElite.web.controller;

import com.example.daweb.laElite.persistence.entities.Alumno;
import com.example.daweb.laElite.services.AlumnoService;
import com.example.daweb.laElite.services.exceptions.AlumnoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.alumnoService.create(alumno));
        } catch (AlumnoException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }
}
