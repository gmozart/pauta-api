package com.pautaapi.dto;

import com.pautaapi.entity.Associado;
import com.pautaapi.entity.Pauta;
import com.pautaapi.entity.Votacao;
import lombok.Builder;
import lombok.Data;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@Builder
public class VotacaoDTO {

    private Long id;

    private Pauta pauta;

    private Associado associado;

    private Boolean voto;

    public static VotacaoDTO of(Votacao votacao){
        return VotacaoDTO.builder()
                .id(votacao.getId())
                .pauta(votacao.getPauta())
                .associado(votacao.getAssociado())
                .voto(votacao.getVoto())
                .build();
    }

    public static Votacao of(VotacaoDTO votacaoDTO){
        return Votacao.builder()
                .id(votacaoDTO.getId())
                .pauta(votacaoDTO.getPauta())
                .associado(votacaoDTO.getAssociado())
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
