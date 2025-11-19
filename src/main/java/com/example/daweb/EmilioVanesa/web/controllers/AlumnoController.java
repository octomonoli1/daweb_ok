package com.example.daweb.EmilioVanesa.web.controllers;

import com.example.daweb.EmilioVanesa.service.AlumnoService;
import com.example.daweb.EmilioVanesa.service.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/alumno")
public class AlumnoController {



        @Autowired
        private AlumnoService alumnoService;



        @GetMapping("/{id}")
        public ResponseEntity<?> findById(@PathVariable int id){
            try{
                return ResponseEntity.ok(this.alumnoService.findById(id));
            }catch (AlumnoNotFoundException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
        }



    }
