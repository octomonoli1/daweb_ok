package com.example.daweb.FranyAlvaro.persistance.repositories;
import com.example.daweb.FranyAlvaro.persistance.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("alumnoRepositoryFranyAlvaro")
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
}