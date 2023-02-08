package com.pautaapi.service;

import com.pautaapi.dto.PautaDTO;
import com.pautaapi.repository.PautaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PautaService {

    private final PautaRepository pautaRepository;

    public void save(PautaDTO pautaDTO){
        pautaRepository.save(PautaDTO.of(pautaDTO));
    }

    public Optional<PautaDTO> findById(Long id){
        return PautaDTO.of(pautaRepository.findById(id));
    }

    public Optional<List<PautaDTO>> findAll(){
        return Optional.of(PautaDTO.of(pautaRepository.findAll()));
    }

    public Optional<PautaDTO> update(Long id, PautaDTO pautaDTO){
        return Optional.of(PautaDTO.of(pautaRepository.save(PautaDTO.of(pautaDTO))));
    }

    public void delete(Long id){
        pautaRepository.deleteById(id);
    }
}
