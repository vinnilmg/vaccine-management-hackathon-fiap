package com.fiap.hackathon.agendamento.infra.client.request;

public record CreateHistoricoVacinacaoRequest(
        Long usuarioId,
        Long vacinaId,
        Long localId,
        String dataAplicacao
) {
}
