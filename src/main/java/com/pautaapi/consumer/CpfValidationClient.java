package com.pautaapi.consumer;

import com.pautaapi.consumer.response.CpfValidationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cpfaValidationClient", url = "https://user-info.herokuapp.com/users/{cpf}")
public interface CpfValidationClient {

    @GetMapping("/{cpf}")
    CpfValidationResponse validaCpf(String cpf);
}
