package com.example.daweb.RaquelyMiguel.web.controllers;

import com.example.daweb.RaquelyMiguel.services.AlumnoService;
import com.example.daweb.RaquelyMiguel.services.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(this.alumnoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            alumnoService.deleteById(id);
            return ResponseEntity.ok("Alumno " + id + " eliminado correctamente.");
        } catch (AlumnoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
