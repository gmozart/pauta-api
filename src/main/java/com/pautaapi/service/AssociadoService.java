package com.pautaapi.service;

import com.pautaapi.dto.AssociadoDTO;
import com.pautaapi.repository.AssociadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepository associadoRepository;

    public void save(AssociadoDTO associadoDTO){
        log.info("Criando um novo associado");
        associadoRepository.save(AssociadoDTO.of(associadoDTO));
    }

    public Optional<AssociadoDTO> findById(Long id){
        log.info("Buscando associado por Id");
        return AssociadoDTO.of(associadoRepository.findById(id));
    }

    public Optional<List<AssociadoDTO>> findAll(){
        log.info("Retorna uma lista de associado ");
        return Optional.of(AssociadoDTO.of(associadoRepository.findAll()));
    }

    public Optional<AssociadoDTO> update(Long id, AssociadoDTO associadoDTO){
        log.info("Atualiza os dados do associado.");
        return Optional.of(AssociadoDTO.of(associadoRepository.save(AssociadoDTO.of(associadoDTO))));
    }

    public void delete(Long id){
        log.info("Deleta associado pelo Id informado..");
        associadoRepository.deleteById(id);
    }
}
