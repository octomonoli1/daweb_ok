package com.example.daweb.spcajcservice;

import com.example.daweb.spcajc.persistence.repositories.AlumnoRepository;
import com.example.daweb.spcajc.service.AlumnoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {
    @Mock
    private AlumnoRepository alumnoRepository;

    @InjectMocks
    private AlumnoService alumnoService;

    @Test
    public void findByName_Ok(){
        // given

        // when

        // then

    }
}
