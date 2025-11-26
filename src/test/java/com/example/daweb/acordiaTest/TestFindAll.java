package com.example.daweb.acordiaTest;

import com.example.daweb.RaquelyMiguel.persistence.entities.Alumno;
import com.example.daweb.RaquelyMiguel.persistence.repositories.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestFindAll {

    @Test
    void testFindAll() {
        AlumnoRepository repo = Mockito.mock(AlumnoRepository.class);

        Mockito.when(repo.findAll())
                .thenReturn(Arrays.asList(new Alumno(), new Alumno()));

        assert repo.findAll().size() == 2;
    }

}