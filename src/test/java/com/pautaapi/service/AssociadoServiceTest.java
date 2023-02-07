package com.pautaapi.service;

import com.pautaapi.dto.AssociadoDTO;
import com.pautaapi.entity.Associado;
import com.pautaapi.repository.AssociadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AssociadoServiceTest {

    private static final Long ID = 1l;
    private  static final String CPF = "14523548485";

    @InjectMocks
    private AssociadoService associadoService;

    @Mock
    private AssociadoRepository associadoRepository;

    private Associado associado;
    private  AssociadoDTO associadoDTO;
    private Optional<AssociadoDTO> optionalAssociado;

    @BeforeEach
    void setUp(){

        starterAssociado();

    }


    @Test
    void whenSaveAssociadoTest() {

        ArgumentCaptor Associado = ArgumentCaptor.forClass(AssociadoDTO.class);


    }

    @Test
    void whenFindByIdTest() {
        when(associadoRepository.findById(anyLong())).thenReturn(Optional.of(AssociadoDTO.of(associadoDTO)));
        Optional<AssociadoDTO> response = associadoService.findById(ID);
        assertNotNull(response);
        assertEquals(Optional.class, response.getClass());
        assertEquals(ID, response.get().getId());
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

    private void starterAssociado(){
        associado = new Associado(ID, CPF);
        associadoDTO = AssociadoDTO.of(new Associado(ID,CPF));
        optionalAssociado = Optional.of(AssociadoDTO.of(new Associado(ID,CPF)));
    }


}