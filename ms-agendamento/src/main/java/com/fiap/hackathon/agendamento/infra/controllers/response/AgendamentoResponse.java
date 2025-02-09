package com.fiap.hackathon.agendamento.infra.controllers.response;

public record AgendamentoResponse(
    Long agendamentoId,
    Long usuarioId,
    Long postoVacinacaoId,
    Long vacinaId,
    String data,
    String hora,
    String status
) {
}
