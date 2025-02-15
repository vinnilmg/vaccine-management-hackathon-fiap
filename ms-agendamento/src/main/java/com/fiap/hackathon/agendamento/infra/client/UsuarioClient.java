package com.fiap.hackathon.agendamento.infra.client;

import com.fiap.hackathon.agendamento.infra.client.response.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "usuario", url = "${ms-usuario.host}")
public interface UsuarioClient {

    @GetMapping(value = "/usuarios/{usuarioId}", produces = "application/json")
    UsuarioResponse getUsuarioById(@PathVariable Long usuarioId);
}
