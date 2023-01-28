package com.pautaapi.dto;

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

    private LocalDateTime abertura;

    private LocalDateTime encerramento;

    public static PautaDTO of(Pauta pauta){
        return PautaDTO.builder()
                .id(pauta.getId())
                .titulo(pauta.getTitulo())
                .descricao(pauta.getDescricao())
                .abertura(pauta.getAbertura())
                .encerramento(pauta.getEncerramento())
                .build();
    }

    public static Pauta of(PautaDTO pautaDTO){
        return Pauta.builder()
                .id(pautaDTO.getId())
                .titulo(pautaDTO.getTitulo())
                .descricao(pautaDTO.getDescricao())
                .abertura(pautaDTO.getAbertura())
                .encerramento(pautaDTO.getEncerramento())
                .build();
    }

    public static Optional<PautaDTO> of(Optional<Pauta> pauta){
        return pauta.stream().map(PautaDTO::of).findAny();
    }

    public static List<PautaDTO> of(List<Pauta> pauta){
        return pauta.stream().map(PautaDTO::of).collect(Collectors.toList());
    }

}
