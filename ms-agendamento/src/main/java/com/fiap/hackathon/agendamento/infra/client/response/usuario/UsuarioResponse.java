package com.fiap.hackathon.agendamento.infra.client.response.usuario;

public record UsuarioResponse(
    Long id,
    String email,
    String nome,
    String cpf,
    String numeroCarteira
) {
}
