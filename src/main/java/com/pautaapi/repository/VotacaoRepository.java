package com.pautaapi.repository;

import com.pautaapi.entity.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {

    @Query("select count(voto) from Votacao where pauta.id = :id and voto <> 0")
    Integer numberVotesInFavor(Long id);

    @Query("select count(pauta.id) from Votacao where pauta.id = :id and voto <> 1")
    Integer numberVotesAgainst(Long id);

    @Query("select count(pauta.id) from Votacao where pauta.id = :id")
    Integer numberOfVotes(Long id);

}
