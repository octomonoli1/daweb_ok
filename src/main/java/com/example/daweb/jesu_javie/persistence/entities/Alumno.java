package com.example.daweb.jesu_javie.persistence.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

@Entity
    @Table(name = "alumno")
    public class Alumno {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String name;

        private String surname;

        private LocalDate birth;


    }
