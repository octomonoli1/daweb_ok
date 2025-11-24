package com.example.daweb.jesu_javie.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.daweb.jesu_javie.persistence.entities.Alumno;
import com.example.daweb.jesu_javie.services.AlumnoService;
import com.example.daweb.jesu_javie.services.exceptions.AlumnoException;
import com.example.daweb.jesu_javie.services.exceptions.AlumnoNotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private AlumnoService alumnoService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Alumno alumno) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.create(alumno));
        } catch (AlumnoException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Alumno alumno) {
        try {
            return ResponseEntity.ok(alumnoService.update(id, alumno));
        } catch (AlumnoNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (AlumnoException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            alumnoService.delete(id);
            return ResponseEntity.ok("Alumno eliminado correctamente");
        } catch (AlumnoNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    */
}