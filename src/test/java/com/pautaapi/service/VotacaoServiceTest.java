package com.pautaapi.service;

import com.pautaapi.dto.VotacaoDTO;
import com.pautaapi.entity.Votacao;
import com.pautaapi.repository.AssociadoRepository;
import com.pautaapi.repository.PautaRepository;
import com.pautaapi.repository.VotacaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class VotacaoServiceTest {

    @InjectMocks
    private VotacaoService votacaoService;

    @Mock
    private VotacaoRepository votacaoRepository;

    @Mock
    private AssociadoRepository associadoRepository;

    @Mock
    private PautaRepository pautaRepository;

    private VotacaoDTO votacaoDTO;

    @Captor
    private ArgumentCaptor<Votacao> captor;

    private static final Long ID = 1L;
    private static final Long IDPAUTA = 1L;
    private static final Long IDASSOCIADO = 1L;
    private static final String SNVOTO = "S";

    @Test
    void whenSaveVoto() {

    }

    @Test
    void WhenFindIdVoto() {
    }

    @Test
    void whenFindAllVoto() {
    }

    @Test
    void numberVotesInFavor() {
    }

    @Test
    void numberVotesAgainst() {
    }

    @Test
    void numberofVotes() {
    }

    @Test
    void aprovalPauta() {
    }

    private void starterVoto(){



    }
}