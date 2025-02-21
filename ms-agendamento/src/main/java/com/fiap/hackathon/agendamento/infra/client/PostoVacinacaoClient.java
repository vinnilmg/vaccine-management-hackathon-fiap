package com.fiap.hackathon.agendamento.infra.client;

import com.fiap.hackathon.agendamento.infra.client.response.posto.vacinacao.PostoVacinacaoResponse;
import com.fiap.hackathon.agendamento.infra.client.response.posto.vacinacao.lote.LoteVacinaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "posto-vacinacao", url = "${ms-postos-vacina.host}")
public interface PostoVacinacaoClient {

    @GetMapping(value = "/postos/{postoVacinacaoId}", produces = "application/json")
    PostoVacinacaoResponse getPostoVacinacaoById(@PathVariable Long postoVacinacaoId);

    @GetMapping(value = "/postos/{postoVacinacaoId}/vacinas/{vacinaId}/lote", produces = "application/json")
    LoteVacinaResponse getLoteByPostoVacinacaoIdAndVacinaId(
        @PathVariable Long postoVacinacaoId,
        @PathVariable Long vacinaId
    );

    @PutMapping(value = "/postos/{postoVacinacaoId}/vacinas/{vacinaId}/lote/diminuir-estoque")
    void decreaseStock(@PathVariable Long postoVacinacaoId, @PathVariable Long vacinaId);

    @PutMapping(value = "/postos/{postoVacinacaoId}/vacinas/{vacinaId}/lote/aumentar-estoque")
    void increaseStock(@PathVariable Long postoVacinacaoId, @PathVariable Long vacinaId);
}
