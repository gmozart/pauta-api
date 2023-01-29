package com.pautaapi.controller;

import com.pautaapi.dto.AssociadoDTO;
import com.pautaapi.dto.PautaDTO;
import com.pautaapi.dto.VotacaoDTO;
import com.pautaapi.service.AssociadoService;
import com.pautaapi.service.VotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/votacoes")
public class VotacaoController {

    private final VotacaoService votacaoService;

    @PostMapping
    public ResponseEntity<VotacaoDTO> save(@RequestBody VotacaoDTO votacaoDTO){
        votacaoService.save(votacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VotacaoDTO> findId(@PathVariable Long id){
        return ResponseEntity.ok(votacaoService.findId(id).orElseThrow());
    }

    @GetMapping
    public ResponseEntity<List<VotacaoDTO>> findAll(){
        return ResponseEntity.ok(votacaoService.findAll().orElseThrow());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VotacaoDTO> update(@PathVariable Long id, @RequestBody VotacaoDTO votacaoDTO){
        return ResponseEntity.ok(votacaoService.update(id, votacaoDTO).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VotacaoDTO> delete(@PathVariable Long id){
        votacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
