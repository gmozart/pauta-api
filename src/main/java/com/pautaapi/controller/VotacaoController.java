package com.pautaapi.controller;

import com.pautaapi.dto.VotacaoDTO;
import com.pautaapi.exception.ptNotFoundException;
import com.pautaapi.service.VotacaoService;
import com.pautaapi.util.ResponseApi;
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

    @PostMapping("/associado/{associadoId}/pauta/{pautaId}")
    public ResponseEntity<ResponseApi> save(@RequestBody VotacaoDTO votacaoDTO, @PathVariable Long associadoId , @PathVariable Long pautaId){
        votacaoDTO.setPautaId(pautaId);
        votacaoDTO.setAssociadoId(associadoId);
        return ResponseEntity.ok(votacaoService.save(votacaoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VotacaoDTO> findId(@PathVariable Long id){
        return ResponseEntity.ok(votacaoService.findById(id).orElseThrow(ptNotFoundException::new));
    }

    @GetMapping
    public ResponseEntity<List<VotacaoDTO>> findAll(){
        return ResponseEntity.ok(votacaoService.findAll().orElseThrow(ptNotFoundException::new));
    }
    
    @GetMapping("/numbervotes/{id}")
    public ResponseEntity<Integer> numberOfVotesPauta(@PathVariable Long id){
        return ResponseEntity.ok(votacaoService.numberofVotes(id));
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
