package com.fiap.hackathon.agendamento.infra.client;

import com.fiap.hackathon.agendamento.infra.client.request.CreateHistoricoVacinacaoRequest;
import com.fiap.hackathon.agendamento.infra.client.response.usuario.UsuarioResponse;
import com.fiap.hackathon.agendamento.infra.client.response.usuario.historico.HistoricoVacinaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "usuario", url = "${ms-usuario.host}")
public interface UsuarioClient {

    @GetMapping(value = "/usuarios/{usuarioId}", produces = "application/json")
    UsuarioResponse getUsuarioById(@PathVariable Long usuarioId);

    @GetMapping(value = "/usuarios/{usuarioId}/movimentacao-vacina/vacina/{vacinaId}", produces = "application/json")
    List<HistoricoVacinaResponse> getHistoricoVacinacaoByUsuarioAndVacinaId(
            @PathVariable Long usuarioId,
            @PathVariable Long vacinaId
    );

    @PostMapping(value = "/movimentacao-vacina", consumes = "application/json")
    void createHistoricoVacinacao(@RequestBody CreateHistoricoVacinacaoRequest request);
}
