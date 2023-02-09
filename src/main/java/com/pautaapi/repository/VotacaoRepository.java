package com.pautaapi.repository;

import com.pautaapi.entity.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {

    @Query("select count(snVoto) from Votacao where pauta.id = :id and snVoto <> 'N'")
    Integer numberVotesInFavor(Long id);

    @Query("select count(pauta.id) from Votacao where pauta.id = :id and snVoto <> 'S'")
    Integer numberVotesAgainst(Long id);

    @Query("select count(pauta.id) from Votacao where pauta.id = :id")
    Integer numberOfVotes(Long id);

}
