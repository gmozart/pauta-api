package com.pautaapi.repository;

import com.pautaapi.entity.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoRepository extends JpaRepository<Votacao, Long> {
}
