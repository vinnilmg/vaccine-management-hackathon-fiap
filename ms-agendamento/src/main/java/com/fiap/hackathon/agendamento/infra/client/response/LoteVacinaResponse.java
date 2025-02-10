package com.fiap.hackathon.agendamento.infra.client.response;

public record LoteVacinaResponse(
        Long id,
        String codigo,
        Integer estoque,
        String validade
) {
}
