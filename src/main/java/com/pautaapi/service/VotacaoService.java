package com.pautaapi.service;

import com.pautaapi.dto.VotacaoDTO;
import com.pautaapi.entity.Associado;
import com.pautaapi.entity.Pauta;
import com.pautaapi.entity.Votacao;
import com.pautaapi.repository.AssociadoRepository;
import com.pautaapi.repository.PautaRepository;
import com.pautaapi.repository.VotacaoRepository;
import com.pautaapi.util.ResponseApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class VotacaoService {

    private final VotacaoRepository votacaoRepository;

    private final AssociadoRepository associadoRepository;

    private final PautaRepository pautaRepository;

    public ResponseApi save(VotacaoDTO votacaoDTO) {
        Pauta pauta = pautaRepository.findById(votacaoDTO.getPautaId()).get();
        Associado associado = associadoRepository.findById(votacaoDTO.getAssociadoId()).get();
        if(LocalDateTime.now().isAfter(pauta.getFechamento())){
            log.info("Voto não salvo a pauta está expirada.");
            return ResponseApi.builder().body("A pauta esta expirada!").build();
        }
        Votacao votacao = Votacao.builder().id(votacaoDTO.getId()).pauta(pauta).associado(associado).snVoto(votacaoDTO.getSnVoto()).build();
        votacaoRepository.save(votacao);
        log.info("Voto salvo e computado");
        return ResponseApi.builder().body("Voto computado com sucesso!").build();
    }
    public Optional<VotacaoDTO> findById(Long id) {
        log.info("Busca dos votos pelo id");
        return VotacaoDTO.of(votacaoRepository.findById(id));
    }
    public Optional<List<VotacaoDTO>> findAll() {
        log.info("Retorna uma lista de votos.");
        return Optional.of(VotacaoDTO.of(votacaoRepository.findAll()));
    }

    public Integer numberVotesInFavor(Long id) {
        log.info("Retorna quantidade de votos afavor da pauta");
        return votacaoRepository.numberVotesInFavor(id);
    }
    public Integer numberVotesAgainst(Long id) {
        log.info("Retorna quantidade de votos contra da pauta");
        return votacaoRepository.numberVotesAgainst(id);
    }
    public Integer numberofVotes(Long id) {
        log.info("Retorna quantidade de votos de uma pauta.");
        return votacaoRepository.numberOfVotes(id);
    }
}