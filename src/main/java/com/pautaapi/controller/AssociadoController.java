package com.pautaapi.controller;

import com.pautaapi.dto.AssociadoDTO;
import com.pautaapi.exception.ptNotFoundException;
import com.pautaapi.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/associados")
public class AssociadoController {

    private final AssociadoService associadoService;

    @PostMapping
    public ResponseEntity<AssociadoDTO> save(@RequestBody AssociadoDTO associadoDTO){
        associadoService.save(associadoDTO);
        log.info("Criando um novo associado");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociadoDTO> findById(@PathVariable Long id){
        log.info("Retornando associado por id.");
        return ResponseEntity.ok(associadoService.findById(id).orElseThrow(ptNotFoundException::new));
    }

    @GetMapping
    public ResponseEntity<List<AssociadoDTO>> findAll(){
        log.info("Retornando uma lista de associados.");
        return ResponseEntity.ok(associadoService.findAll().orElseThrow(ptNotFoundException::new));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssociadoDTO> update(@PathVariable Long id, @RequestBody AssociadoDTO associadoDTO){
        log.info("Atualizando dados de um associado");
        return ResponseEntity.ok(associadoService.update(id,associadoDTO).orElseThrow(ptNotFoundException::new));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssociadoDTO> delete(@PathVariable Long id){
        associadoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
