package com.fiap.hackathon.agendamento.infra.client.response;

public record FuncionamentoPostoResponse(
    String dia,
    HorarioFuncionamentoResponse horario
) {
}
