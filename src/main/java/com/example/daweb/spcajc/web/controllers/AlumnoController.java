package com.example.daweb.spcajc.web.controllers;

import com.example.daweb.spcajc.service.AlumnoService;
import com.example.daweb.spcajc.service.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@RequestParam String name){
        try{
            return ResponseEntity.ok(this.alumnoService.findByName(name));
        }catch (AlumnoNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
