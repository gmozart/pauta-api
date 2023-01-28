package com.pautaapi.controller;

import com.pautaapi.dto.PautaDTO;
import com.pautaapi.entity.Pauta;
import com.pautaapi.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/pautas")
public class PautaController {

    private final PautaService pautaService;

    @PostMapping
    public ResponseEntity<PautaDTO> save(@RequestBody PautaDTO pautaDTO){
        pautaService.save(pautaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaDTO> findId(@PathVariable Long id){
        return ResponseEntity.ok(pautaService.findId(id).orElseThrow());
    }

    @GetMapping
    public ResponseEntity<List<PautaDTO>> findAll(){
        return ResponseEntity.ok(pautaService.findAll().orElseThrow());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PautaDTO> update(@PathVariable Long id, @RequestBody PautaDTO pautaDTO){
        return ResponseEntity.ok(pautaService.update(id, pautaDTO).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PautaDTO> delete(@PathVariable Long id){
        pautaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
