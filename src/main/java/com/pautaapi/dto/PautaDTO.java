package com.pautaapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pautaapi.entity.Pauta;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Data
@Builder
public class PautaDTO {

    private Long id;

    private String titulo;

    private String descricao;
    @JsonIgnore
    private LocalDateTime abertura;

    private LocalDateTime fechamento;

    @JsonIgnore
    private String snAprovada;

    public static PautaDTO of(Pauta pauta){
        return PautaDTO.builder()
                .id(pauta.getId())
                .titulo(pauta.getTitulo())
                .descricao(pauta.getDescricao())
                .abertura(pauta.getAbertura())
                .fechamento(pauta.getFechamento())
                .snAprovada(pauta.getSnAprovada())
                .build();
    }
    public static Pauta of(PautaDTO pautaDTO){
        return Pauta.builder()
                .id(pautaDTO.getId())
                .titulo(pautaDTO.getTitulo())
                .descricao(pautaDTO.getDescricao())
                .abertura(pautaDTO.getAbertura())
                .fechamento(pautaDTO.getFechamento())
                .snAprovada(pautaDTO.getSnAprovada())
                .build();
    }
    public static Optional<PautaDTO> of(Optional<Pauta> pauta){
        return pauta.stream().map(PautaDTO::of).findAny();
    }
    public static List<PautaDTO> of(List<Pauta> pauta){
        return pauta.stream().map(PautaDTO::of).collect(Collectors.toList());
    }
}