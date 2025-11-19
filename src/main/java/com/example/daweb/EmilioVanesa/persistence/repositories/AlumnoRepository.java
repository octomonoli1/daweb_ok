package com.example.daweb.EmilioVanesa.persistence.repositories;

import com.example.daweb.EmilioVanesa.persistence.entities.Alumno;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface AlumnoRepository extends ListCrudRepository<Alumno, Integer> {
        List<Alumno> findById (int id);

    }

