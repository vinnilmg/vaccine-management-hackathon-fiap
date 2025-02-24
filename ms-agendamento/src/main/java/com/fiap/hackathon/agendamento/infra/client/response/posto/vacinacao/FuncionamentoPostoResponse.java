package com.fiap.hackathon.agendamento.infra.client.response.posto.vacinacao;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FuncionamentoPostoResponse(
        @JsonProperty("diaSemana")
        String dia,
        @JsonProperty("horarioInicio")
        String inicio,
        @JsonProperty("horarioFim")
        String termino
) {
}
