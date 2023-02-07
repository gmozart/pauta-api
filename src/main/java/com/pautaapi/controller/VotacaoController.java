package com.pautaapi.controller;

import com.pautaapi.dto.VotacaoDTO;
import com.pautaapi.exception.ptNotFoundException;
import com.pautaapi.service.VotacaoService;
import lombok.RequiredArgsConstructor;
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
        return ResponseEntity.ok(votacaoService.findId(id).orElseThrow(ptNotFoundException::new));
    }

    @GetMapping
    public ResponseEntity<List<VotacaoDTO>> findAll(){
        return ResponseEntity.ok(votacaoService.findAll().orElseThrow(ptNotFoundException::new));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VotacaoDTO> update(@PathVariable Long id, @RequestBody VotacaoDTO votacaoDTO){
        return ResponseEntity.ok(votacaoService.update(id, votacaoDTO).orElseThrow(ptNotFoundException::new));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VotacaoDTO> delete(@PathVariable Long id){
        votacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/numbervotes/{id}")
    public ResponseEntity<Integer> numberOfVotesPauta(@PathVariable Long id){
        return ResponseEntity.ok(votacaoService.numberofVotes(id));
    }

    @GetMapping("/result/{id}")
    public ResponseEntity<String> resultPauta(@PathVariable Long id){
        return ResponseEntity.ok(votacaoService.aprovalPauta(id).orElseThrow(ptNotFoundException::new));
    }

    @GetMapping("/votesinfavor/{id}")
    public ResponseEntity<Integer> votesInFavor(@PathVariable Long id){
        return  ResponseEntity.ok(votacaoService.numberVotesInFavor(id));
    }

    @GetMapping("/votesagainst/{id}")
    public ResponseEntity<Integer> votesAgainst(@PathVariable Long id){
        return ResponseEntity.ok(votacaoService.numberVotesAgainst(id));
    }

}
