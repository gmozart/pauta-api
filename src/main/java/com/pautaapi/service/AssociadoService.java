package com.pautaapi.service;

import com.pautaapi.dto.AssociadoDTO;
import com.pautaapi.repository.AssociadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepository associadoRepository;

    public void save(AssociadoDTO associadoDTO){
      associadoRepository.save(AssociadoDTO.of(associadoDTO));
    }

    public Optional<AssociadoDTO> findById(Long id){
        return AssociadoDTO.of(associadoRepository.findById(id));
    }

    public Optional<List<AssociadoDTO>> findAll(){
        return Optional.of(AssociadoDTO.of(associadoRepository.findAll()));
    }

    public Optional<AssociadoDTO> update(Long id, AssociadoDTO associadoDTO){
        return Optional.of(AssociadoDTO.of(associadoRepository.save(AssociadoDTO.of(associadoDTO))));
    }

    public void delete(Long id){
        associadoRepository.deleteById(id);
    }
}
