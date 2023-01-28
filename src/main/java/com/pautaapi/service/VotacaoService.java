package com.pautaapi.service;


import com.pautaapi.dto.VotacaoDTO;
import com.pautaapi.repository.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotacaoService {

    private final VotacaoRepository votacaoRepository;

    public void save(VotacaoDTO votacaoDTO){
        votacaoRepository.save(VotacaoDTO.of(votacaoDTO));
    }

    public Optional<VotacaoDTO> findId(Long id){
        return VotacaoDTO.of(votacaoRepository.findById(id));
    }

    public Optional<List<VotacaoDTO>> findAll(){
        return Optional.of(VotacaoDTO.of(votacaoRepository.findAll()));
    }

    public Optional<VotacaoDTO> update(Long id, VotacaoDTO votacaoDTO){
        return Optional.of(VotacaoDTO.of(votacaoRepository.save(VotacaoDTO.of(votacaoDTO))));
    }

    public void delete(Long id){
        votacaoRepository.deleteById(id);
    }
}
