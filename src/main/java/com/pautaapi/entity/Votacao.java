package com.pautaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="votacoes")
public class Votacao {

    @Id
    private Long id;

    @ManyToOne
    private Pauta pauta;

    @OneToOne
    private Associado associado;

    private String snVoto;
}