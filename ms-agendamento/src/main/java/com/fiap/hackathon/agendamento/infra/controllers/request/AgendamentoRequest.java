package com.fiap.hackathon.agendamento.infra.controllers.request;

public record AgendamentoRequest(
        String dataHoraAgendamento,
        Long postoVacinacaoId,
        Long vacinaId,
        Long usuarioId
) {
}
