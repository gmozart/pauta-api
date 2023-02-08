package com.pautaapi.service;



import com.pautaapi.dto.PautaDTO;
import com.pautaapi.entity.Pauta;
import com.pautaapi.repository.PautaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;



@ExtendWith(MockitoExtension.class)
class PautaServiceTest {

    @InjectMocks
    private PautaService pautaService;

    @Mock
    private PautaRepository pautaRepository;

    private Pauta pauta;
    private PautaDTO pautaDTO;
    private Optional<PautaDTO> optionalPauta;

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
    void save() {
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