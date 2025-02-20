package com.fiap.hackathon.agendamento.infra.client.response.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioResponse(
    Long id,
    String email,
    String nome,
    String cpf,
    @JsonProperty("numeroCarteirinhaSUS")
    String numeroCarteira
) {
}
