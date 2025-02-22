package com.br.fiap.application.dto.response;

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
