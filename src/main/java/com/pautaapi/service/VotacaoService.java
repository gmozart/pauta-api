package com.pautaapi.service;


import com.pautaapi.consumer.CpfValidationClient;
import com.pautaapi.consumer.response.CpfValidationResponse;
import com.pautaapi.dto.VotacaoDTO;
import com.pautaapi.repository.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static com.pautaapi.consumer.response.StatusCpfValidation.ABLE_TO_VOTE;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@Service
@RequiredArgsConstructor
public class VotacaoService {

    private final VotacaoRepository votacaoRepository;
    private final CpfValidationClient cpfValidationClient;

    public void save(VotacaoDTO votacaoDTO){
        if(verificaCpf(votacaoDTO)) {
            votacaoRepository.save(VotacaoDTO.of(votacaoDTO));
        }
    }

    public Optional<VotacaoDTO> findId(Long id){
        return VotacaoDTO.of(votacaoRepository.findById(id));
    }

    public Optional<List<VotacaoDTO>> findAll(){
        return Optional.of(VotacaoDTO.of(votacaoRepository.findAll()));
    }

    public Optional<VotacaoDTO> update(Long id, VotacaoDTO votacaoDTO){
        return Optional.of(VotacaoDTO.of(votacaoRepository.save(VotacaoDTO.of(votacaoDTO))));
    }

    public void delete(Long id){
        votacaoRepository.deleteById(id);
    }

    public Integer numberVotesInFavor(Long id){
        return  votacaoRepository.numberVotesInFavor(id);
    }
    public Integer numberVotesAgainst(Long id){
        return votacaoRepository.numberVotesAgainst(id);
    }

    public Integer numberofVotes(Long id){
        return votacaoRepository.numberOfVotes(id);
    }

    public Optional<String> aprovalPauta(Long id) {


        Integer inFavor = votacaoRepository.numberVotesInFavor(id);
        Integer aGainst = votacaoRepository.numberVotesAgainst(id);

           if(inFavor > aGainst){
               return Optional.of("Aprovado");
               }else {
               return Optional.of("Reprovado");
           }
    }

    private boolean verificaCpf(VotacaoDTO votacaoDTO) {
        CpfValidationResponse response = cpfValidationClient.validaCpf(votacaoDTO.getAssociado().getCpf());
        if(Optional.ofNullable(response.getStatus()).isPresent()
                && response.getStatus().equals(ABLE_TO_VOTE)) {
            return false;
        }
        return true;
    }

}
