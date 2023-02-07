package com.pautaapi.service;

import com.pautaapi.dto.AssociadoDTO;
import com.pautaapi.entity.Associado;
import com.pautaapi.repository.AssociadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AssociadoServiceTest {

    @InjectMocks
    private AssociadoService associadoService;

    @Mock
    private AssociadoRepository associadoRepository;

    @Test
    void whenSaveAssociadoTest() {

        ArgumentCaptor Associado = ArgumentCaptor.forClass(AssociadoDTO.class);


    }

    @Test
    void whenFindByIdTest() {
        when(associadoRepository.findById(any())).thenReturn(Optional.of(Associado.builder().build()));
        assertNotNull(associadoService.findById(1l));
    }

    @Test
    void whenFindAllTest() {
        when(associadoRepository.findAll()).thenReturn(Collections.singletonList(Associado.builder().build()));
        assertNotNull(associadoService.findAll());
    }

    @Test
    void whenUpdateTest() {





    }

    @Test
    void delete() {
    }
}