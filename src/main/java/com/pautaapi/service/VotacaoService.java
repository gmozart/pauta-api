package com.pautaapi.service;


import com.pautaapi.consumer.CpfValidationClient;
import com.pautaapi.consumer.response.CpfValidationResponse;
import com.pautaapi.dto.PautaDTO;
import com.pautaapi.dto.VotacaoDTO;
import com.pautaapi.entity.Associado;
import com.pautaapi.entity.Pauta;
import com.pautaapi.entity.Votacao;
import com.pautaapi.repository.AssociadoRepository;
import com.pautaapi.repository.PautaRepository;
import com.pautaapi.repository.VotacaoRepository;
import com.pautaapi.util.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.pautaapi.consumer.response.StatusCpfValidation.ABLE_TO_VOTE;


@Service
@RequiredArgsConstructor
public class VotacaoService {

    private final VotacaoRepository votacaoRepository;

    private final AssociadoRepository associadoRepository;

    private final PautaRepository pautaRepository;

    public ResponseApi save(VotacaoDTO votacaoDTO) {
        Pauta pauta = pautaRepository.findById(votacaoDTO.getPautaId()).get();
        Associado associado = associadoRepository.findById(votacaoDTO.getAssociadoId()).get();
        if(LocalDateTime.now().isAfter(pauta.getFechamento())){
            return ResponseApi.builder().body("A pauta esta expirada!").build();
        }
        Votacao votacao = Votacao.builder().id(votacaoDTO.getId()).pauta(pauta).associado(associado).snVoto(votacaoDTO.getSnVoto()).build();
        votacaoRepository.save(votacao);
        return ResponseApi.builder().body("Voto computado com sucesso!").build();
    }
    public Optional<VotacaoDTO> findById(Long id) {
        return VotacaoDTO.of(votacaoRepository.findById(id));
    }
    public Optional<List<VotacaoDTO>> findAll() {
        return Optional.of(VotacaoDTO.of(votacaoRepository.findAll()));
    }

    public Integer numberVotesInFavor(Long id) {
        return votacaoRepository.numberVotesInFavor(id);
    }
    public Integer numberVotesAgainst(Long id) {
        return votacaoRepository.numberVotesAgainst(id);
    }
    public Integer numberofVotes(Long id) {
        return votacaoRepository.numberOfVotes(id);
    }
}