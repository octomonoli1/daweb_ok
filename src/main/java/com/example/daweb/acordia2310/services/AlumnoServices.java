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


}
