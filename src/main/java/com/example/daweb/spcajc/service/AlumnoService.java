package com.example.daweb.spcajc.service;

import com.example.daweb.spcajc.persistence.entities.Alumno;
import com.example.daweb.spcajc.persistence.repositories.AlumnoRepository;
import com.example.daweb.spcajc.service.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findByName(String name){
        List<Alumno> alumnos = this.alumnoRepository.findByName(name);
        if(alumnos.isEmpty()){
            throw new AlumnoNotFoundException("No se ha encontrado ningun alumno con este nombre");
        }else{
            return this.alumnoRepository.findByName(name);
        }
    }
}
