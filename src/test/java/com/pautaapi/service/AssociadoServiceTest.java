package com.pautaapi.service;

import com.pautaapi.dto.AssociadoDTO;
import com.pautaapi.entity.Associado;
import com.pautaapi.repository.AssociadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


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

    @Captor
    private ArgumentCaptor<Associado> captor;

    @BeforeEach
    void setUp(){
        starterAssociado();
    }


    @Test
    void whenSaveAssociadoTest() {
        associadoService.save(associadoDTO);
        verify(associadoRepository).save(captor.capture());
        Associado captured = captor.getValue();
        assertThat(captured.getId().equals(ID) && captured.getCpf().equals(CPF));
        assertNotNull(captured);
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
        Optional<List<AssociadoDTO>> response = associadoService.findAll();
        assertNotNull(response);
        assertEquals(1,response.get().size());
        assertEquals(AssociadoDTO.class, response.get().get(0).getClass());
    }

    @Test
    void whenUpdateTest() {
        associadoService.update(ID, associadoDTO);
        verify(associadoRepository).save(captor.capture());
        Associado captured = captor.getValue();
        assertThat(captured.getId().equals(ID) && captured.getCpf().equals(CPF));
        assertNotNull(captured);
    }

    @Test
    void deleteWitchSucessTest() {
        when(associadoRepository.findById(anyLong())).thenReturn(Optional.of(AssociadoDTO.of(associadoDTO)));
        Optional<AssociadoDTO> response = associadoService.findById(ID);
        assertNotNull(response);
        doNothing().when(associadoRepository).deleteById(anyLong());
        associadoService.delete(ID);
        verify(associadoRepository, times(1)).deleteById(anyLong());
    }

    private void starterAssociado(){
        associado = new Associado(ID, CPF);
        associadoDTO = AssociadoDTO.of(new Associado(ID,CPF));
        optionalAssociado = Optional.of(AssociadoDTO.of(new Associado(ID,CPF)));
    }
}