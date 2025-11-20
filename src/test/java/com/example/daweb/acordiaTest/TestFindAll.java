package com.example.daweb.acordiaTest;

import com.example.daweb.acordia2310.persistence.Entity.AlumnoEntity;
import com.example.daweb.acordia2310.persistence.Repository.AlumnoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestFindAll {

    @Test
    void testFindAll() {
        AlumnoRepository repo = Mockito.mock(AlumnoRepository.class);

        // Lo que queremos que devuelva
        Mockito.when(repo.findAll()).thenReturn(List.of(new AlumnoEntity(), new AlumnoEntity()));

        // Comprobación super simple
        assert repo.findAll().size() == 2;
    }
}