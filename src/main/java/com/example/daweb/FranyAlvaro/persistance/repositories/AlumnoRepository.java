package com.example.daweb.FranyAlvaro.persistance.repositories;
import com.example.daweb.FranyAlvaro.persistance.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}