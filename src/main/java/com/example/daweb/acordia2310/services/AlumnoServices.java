package com.example.daweb.acordia2310.services;

import com.example.daweb.acordia2310.persistence.Entity.AlumnoEntity;
import com.example.daweb.acordia2310.persistence.Repository.AlumnoRepository;
import com.example.daweb.acordia2310.services.Exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServices {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<AlumnoEntity> findAll() {
        return this.alumnoRepository.findAll();
    }

    public AlumnoEntity findById(int id) {
        if (this.alumnoRepository.existsById(id)) {
            return this.alumnoRepository.findById(id).get();
        }else {
            throw new AlumnoNotFoundException("No se encuentra el alumno asignado");
        }
    }

    public void deleteById(int id) {
        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
    }

    public List<AlumnoEntity> findByName(String name){
        List<AlumnoEntity> alumnos = this.alumnoRepository.findByName(name);
        if(alumnos.isEmpty()){
            throw new AlumnoNotFoundException("No se ha encontrado ningun alumno con este nombre");
        }else{
            return this.alumnoRepository.findByName(name);
        }
    }
}
