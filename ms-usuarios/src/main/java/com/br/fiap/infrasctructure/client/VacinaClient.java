package com.br.fiap.infrasctructure.client;

import com.br.fiap.application.dto.response.VacinaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "vacina", url = "${ms-vacina.host}")
public interface VacinaClient {

    @GetMapping(value = "/vacinas/{vacinaId}", produces = "application/json")
    VacinaResponse getVacinaById(@PathVariable Long vacinaId);
}
