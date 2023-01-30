package com.pautaapi.consumer;

import com.pautaapi.consumer.response.CpfValidationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cfaValidationClient", url = "https://user-info.herokuapp.com/users")
public interface CpfValidationClient {

    @GetMapping("/{cpf}")
    CpfValidationResponse validaCpf(String cpf);
}
