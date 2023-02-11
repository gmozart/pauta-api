package com.pautaapi.service;

import com.pautaapi.dto.PautaDTO;
import com.pautaapi.entity.Pauta;
import com.pautaapi.repository.PautaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class PautaServiceTest {

    @InjectMocks
    private PautaService pautaService;

    @Mock
    private PautaRepository pautaRepository;
    private Pauta pauta;
    private PautaDTO pautaDTO;
    private Optional<PautaDTO> optionalPauta;

    @Captor
    private ArgumentCaptor<Pauta> captor;

    private static final Long ID = 1L;
    private static final String TITULO = "Pauta para o aumento do salário";
    private static final String DESCRICAO = "O salário dos funcionários deve ter um aumento de 5%?";
    private static final LocalDateTime ABERTURA = LocalDateTime.now();
    private static final LocalDateTime FECHAMENTO = LocalDateTime.now();
    private static final String SNAPROVADA = "N";


    @BeforeEach
    void setUp(){
        starterPauta();
    }

    @Test
    void whenSaveTest() {
        pautaService.save(pautaDTO);
        verify(pautaRepository).save(captor.capture());
        Pauta captured = captor.getValue();
        assertNotNull(captured);
    }


    @Test
    void whenFindIdTest() {
        when(pautaRepository.findById(anyLong())).thenReturn(Optional.of(PautaDTO.of(pautaDTO)));
        Optional<PautaDTO> response = pautaService.findById(ID);
        assertNotNull(response);
        assertEquals(Optional.class, response.getClass());
        assertEquals(ID, response.get().getId());
    }

    @Test
    void whenFindAll() {
        when(pautaRepository.findAll()).thenReturn(Collections.singletonList(Pauta.builder().build()));
        Optional<List<PautaDTO>> response = pautaService.findAll();
        assertNotNull(response);
        assertEquals(1,response.get().size());
        assertEquals(PautaDTO.class, response.get().get(0).getClass());
    }

    @Test
    void whenUpdateTest() {
        when(pautaRepository.save(any())).thenReturn(PautaDTO.of(pautaDTO));
        Optional<PautaDTO> response = pautaService.update(ID, pautaDTO);
        assertNotNull(response);
        assertEquals(Optional.class, response.getClass());
        assertEquals(ID, response.get().getId());
        assertEquals(TITULO, response.get().getTitulo());
        assertEquals(DESCRICAO ,response.get().getDescricao());
        assertEquals(ABERTURA, response.get().getAbertura());
        assertEquals(FECHAMENTO, response.get().getFechamento());
    }

    @Test
    void whenDeleteTest() {
        when(pautaRepository.findById(anyLong())).thenReturn(Optional.of(PautaDTO.of(pautaDTO)));
        Optional<PautaDTO> response = pautaService.findById(ID);
        assertNotNull(response);
        doNothing().when(pautaRepository).deleteById(anyLong());
        pautaService.delete(ID);
        verify(pautaRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void getPautaResult() {


    }

    private void starterPauta(){
        pauta = new Pauta(ID, TITULO, DESCRICAO,ABERTURA,FECHAMENTO,SNAPROVADA);
        pautaDTO = PautaDTO.of(new Pauta(ID, TITULO, DESCRICAO,ABERTURA,FECHAMENTO,SNAPROVADA));
        optionalPauta= Optional.of(PautaDTO.of(new Pauta(ID, TITULO, DESCRICAO,ABERTURA,FECHAMENTO,SNAPROVADA)));
    }


}