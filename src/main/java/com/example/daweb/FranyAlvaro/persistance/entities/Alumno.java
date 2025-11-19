package com.example.daweb.FranyAlvaro.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "alumno")
@Getter
@Setter
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String nombre;

    @Column(name = "surname")
    private String apellidos;

    @Column(name = "birth")
    private LocalDate fechaNacimiento;

    }
