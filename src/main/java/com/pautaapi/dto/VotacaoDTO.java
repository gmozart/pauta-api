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
    private String snVoto;

    public static VotacaoDTO of(Votacao votacao){
        return VotacaoDTO.builder()
                .id(votacao.getId())
                .pautaId(votacao.getPauta().getId())
                .associadoId(votacao.getAssociado().getId())
                .snVoto(votacao.getSnVoto())
                .build();
    }

    public static Votacao of(VotacaoDTO votacaoDTO){
        return Votacao.builder()
                .id(votacaoDTO.getId())
                .snVoto(votacaoDTO.getSnVoto())
                .build();
    }

    public static Optional<VotacaoDTO> of(Optional<Votacao> votacao){
        return votacao.stream().map(VotacaoDTO::of).findAny();
    }

    public static List<VotacaoDTO> of(List<Votacao> votacao){
        return votacao.stream().map(VotacaoDTO::of).collect(Collectors.toList());
    }
}
