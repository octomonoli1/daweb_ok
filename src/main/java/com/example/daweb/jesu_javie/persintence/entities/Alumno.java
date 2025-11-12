package com.example.daweb.jesu_javie.persintence.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

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
