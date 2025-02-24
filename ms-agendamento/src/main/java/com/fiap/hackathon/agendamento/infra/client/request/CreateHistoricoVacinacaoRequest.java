package com.fiap.hackathon.agendamento.infra.client.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateHistoricoVacinacaoRequest(
        Long usuarioId,
        Long vacinaId,
        Long localId,
        @JsonProperty("data")
        String dataAplicacao
) {
}
