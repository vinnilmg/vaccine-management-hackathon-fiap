package com.fiap.hackathon.agendamento.infra.client.response;

public record UsuarioResponse(
    Long id,
    String email,
    String nome,
    String cpf,
    String numeroCarteira
) {
}
