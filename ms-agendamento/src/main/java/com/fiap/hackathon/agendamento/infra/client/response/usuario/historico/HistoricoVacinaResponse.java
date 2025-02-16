package com.fiap.hackathon.agendamento.infra.client.response.usuario.historico;

public record HistoricoVacinaResponse(
        Long id,
        Long vacina,
        Long local,
        String data
) {
}
