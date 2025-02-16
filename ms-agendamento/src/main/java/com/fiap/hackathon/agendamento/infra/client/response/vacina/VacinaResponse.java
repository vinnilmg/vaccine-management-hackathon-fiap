package com.fiap.hackathon.agendamento.infra.client.response.vacina;

public record VacinaResponse(
        Long id,
        String nome,
        String fabricante,
        Integer doses,
        Integer intervalo
) {
}
