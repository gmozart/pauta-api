package com.pautaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="pautas")
public class Pauta {

    @Id
    private Long id;

    private String titulo;

    private String descricao;

    private LocalDateTime abertura;

    private LocalDateTime fechamento;

    private String snAprovada;
}