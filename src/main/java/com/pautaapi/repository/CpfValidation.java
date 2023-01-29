package com.pautaapi.repository;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://user-info.herokuapp.com/users")
public interface CpfValidation {


    @GetMapping("/{cpf}")
    String verificaCpf(@PathVariable  String cpf);

}
