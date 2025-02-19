package com.fiap.hackathon.agendamento.infra.client.response.vacina;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VacinaResponse(
        Long id,
        String nome,
        String fabricante,
        @JsonProperty("numeroDoses")
        Integer doses,
        @JsonProperty("intervaloDoses")
        Integer intervalo
) {
}
