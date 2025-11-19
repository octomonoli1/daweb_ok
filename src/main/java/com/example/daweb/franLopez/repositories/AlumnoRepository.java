package com.example.daweb.franLopez.repositories;

import com.example.daweb.franLopez.entities.Alumno;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends ListCrudRepository<Alumno, Integer> {


    List<Alumno> findByName(String name);
}
