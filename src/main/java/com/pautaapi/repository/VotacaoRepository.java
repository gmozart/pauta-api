package com.pautaapi.repository;

import com.pautaapi.entity.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {




//    @Query("")
//    public Optional<Long>


}
