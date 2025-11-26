package com.example.daweb.spcajc.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "AlumnoSpcajc")
@Table(name = "alumno")
@Getter
@Setter
@NoArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private LocalDate birth;
}
