package com.pautaapi.service;

import com.pautaapi.dto.PautaDTO;
import com.pautaapi.entity.Pauta;
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
public class PautaService {

    private final PautaRepository pautaRepository;

    private final VotacaoRepository votacaoRepository;

    public void save(PautaDTO pautaDTO) {
        pautaDTO.setAbertura(LocalDateTime.now());
        log.info("Criando um nova Pauta");
        pautaRepository.save(PautaDTO.of(pautaDTO));
    }

    public Optional<PautaDTO> findById(Long id) {
        log.info("Buscando pauta por id");
        return PautaDTO.of(pautaRepository.findById(id));
    }

    public Optional<List<PautaDTO>> findAll() {
        log.info("Retorna uma lista de pautas");
        return Optional.of(PautaDTO.of(pautaRepository.findAll()));
    }

    public Optional<PautaDTO> update(Long id, PautaDTO pautaDTO) {
        log.info("Atualiza os dados da pauta");
        return Optional.of(PautaDTO.of(pautaRepository.save(PautaDTO.of(pautaDTO))));}

    public void delete(Long id) {
        log.info("Deleta a pauta");
        pautaRepository.deleteById(id);}

    public ResponseApi getPautaResult(Long id) {
        Optional<Pauta> pauta = pautaRepository.findById(id);
        Integer votosAfavor = votacaoRepository.numberVotesInFavor(pauta.get().getId());
        Integer votosContra = votacaoRepository.numberVotesAgainst(pauta.get().getId());
        if (LocalDateTime.now().isAfter(pauta.get().getFechamento())) {
            if (votosAfavor > votosContra) {
                pauta.get().setSnAprovada("S");
                pautaRepository.save(pauta.get());
                return ResponseApi.builder().body("Pauta aprovada!").build();
            }else {
                return ResponseApi.builder().body("Pauta reprovada!").build();
            }
        } else {
            return ResponseApi.builder().body("A pauta esta em andamento!").build();
        }
    }
}