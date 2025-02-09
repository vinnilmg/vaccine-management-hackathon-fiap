package com.fiap.hackathon.agendamento.infra.client;

import com.fiap.hackathon.agendamento.infra.client.response.PostoVacinacaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "posto-vacinacao", url = "${ms-postos-vacina.host}")
public interface PostoVacinacaoClient {

    @GetMapping(value = "/posto-vacinacao/{id}", produces = "application/json")
    PostoVacinacaoResponse getPostoVacinacaoById(@PathVariable("id") Long id);
}
