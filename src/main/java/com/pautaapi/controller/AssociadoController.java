package com.pautaapi.controller;

import com.pautaapi.dto.AssociadoDTO;
import com.pautaapi.service.AssociadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/associados")
public class AssociadoController {

    private final AssociadoService associadoService;

    @PostMapping
    public ResponseEntity<AssociadoDTO> save(@RequestBody AssociadoDTO associadoDTO){
        associadoService.save(associadoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssociadoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(associadoService.findById(id).orElseThrow());
    }

    @GetMapping
    public ResponseEntity<List<AssociadoDTO>> findAll(){
        return ResponseEntity.ok(associadoService.findAll().orElseThrow());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssociadoDTO> update(@PathVariable Long id, @RequestBody AssociadoDTO associadoDTO){
        return ResponseEntity.ok(associadoService.update(id,associadoDTO).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AssociadoDTO> delete(@PathVariable Long id){
        associadoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
