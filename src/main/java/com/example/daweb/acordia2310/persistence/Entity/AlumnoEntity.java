package com.example.daweb.acordia2310.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public class AlumnoEntity {
    @Entity
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
}
