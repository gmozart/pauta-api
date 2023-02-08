package com.pautaapi.service;



import com.pautaapi.dto.PautaDTO;
import com.pautaapi.entity.Associado;
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
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


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

    private static final Long ID = 1l;
    private static final String TITULO = "Pauta para o aumento do salário";
    private static final String DESCRICAO = "O salário dos funcionários deve ter um aumento de 5%?";
    private static final LocalDateTime ABERTURA = LocalDateTime.now();
    private static final LocalDateTime ENCERRAMENTO = LocalDateTime.now();
    private static final String SNFECHAMENTO = "N";


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
    void findId() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void starterPauta(){
        pauta = new Pauta(ID, TITULO, DESCRICAO,ABERTURA,ENCERRAMENTO,SNFECHAMENTO);
        pautaDTO = PautaDTO.of(new Pauta(ID, TITULO, DESCRICAO,ABERTURA,ENCERRAMENTO,SNFECHAMENTO));
        optionalPauta= Optional.of(PautaDTO.of(new Pauta(ID, TITULO, DESCRICAO,ABERTURA,ENCERRAMENTO,SNFECHAMENTO)));
    }

}