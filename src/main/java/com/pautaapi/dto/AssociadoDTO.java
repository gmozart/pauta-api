package com.pautaapi.dto;

import com.pautaapi.entity.Associado;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class AssociadoDTO {

    private Long id;
    private String cpf;

    public static AssociadoDTO of(Associado associado){
        return AssociadoDTO.builder()
                .id(associado.getId())
                .cpf(associado.getCpf())
                .build();
    }

    public static Associado of(AssociadoDTO associadoDTO){
        return Associado.builder()
                .id(associadoDTO.getId())
                .cpf(associadoDTO.getCpf())
                .build();
    }

    public static Optional<AssociadoDTO> of(Optional<Associado> associado){
        return associado.stream().map(AssociadoDTO::of).findAny();
    }

    public static List<AssociadoDTO> of(List<Associado> associado){
        return associado.stream().map(AssociadoDTO::of).collect(Collectors.toList());
    }

}
