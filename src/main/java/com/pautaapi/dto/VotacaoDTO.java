package com.pautaapi.dto;

import com.pautaapi.entity.Associado;
import com.pautaapi.entity.Pauta;
import com.pautaapi.entity.Votacao;
import lombok.Builder;
import lombok.Data;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@Builder
public class VotacaoDTO {

    private Long id;
    private Long pautaId;
    private Long associadoId;
    private Boolean voto;

    public static VotacaoDTO of(Votacao votacao){
        return VotacaoDTO.builder()
                .id(votacao.getId())
                .pautaId(votacao.getPauta().getId())
                .associadoId(votacao.getAssociado().getId())
                .voto(votacao.getVoto())
                .build();
    }

    public static Votacao of(VotacaoDTO votacaoDTO){
        return Votacao.builder()
                .id(votacaoDTO.getId())
                .voto(votacaoDTO.getVoto())
                .build();
    }

    public static Optional<VotacaoDTO> of(Optional<Votacao> votacao){
        return votacao.stream().map(VotacaoDTO::of).findAny();
    }

    public static List<VotacaoDTO> of(List<Votacao> votacao){
        return votacao.stream().map(VotacaoDTO::of).collect(Collectors.toList());
    }
}
