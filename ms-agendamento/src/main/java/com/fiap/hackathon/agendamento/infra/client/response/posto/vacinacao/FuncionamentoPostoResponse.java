package com.fiap.hackathon.agendamento.infra.client.response.posto.vacinacao;

public record FuncionamentoPostoResponse(
    String dia,
    HorarioFuncionamentoResponse horario
) {
}
