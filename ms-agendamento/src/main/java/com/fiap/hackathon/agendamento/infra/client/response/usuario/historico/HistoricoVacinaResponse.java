package com.fiap.hackathon.agendamento.infra.client.response.usuario.historico;

import com.fasterxml.jackson.annotation.JsonProperty;

public record HistoricoVacinaResponse(
        Long id,
        @JsonProperty("vacinaId")
        Long vacina,
        @JsonProperty("localId")
        Long local,
        @JsonProperty("dataAplicacao")
        String data
) {
}
