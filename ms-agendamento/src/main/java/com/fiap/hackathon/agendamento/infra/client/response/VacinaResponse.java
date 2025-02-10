package com.fiap.hackathon.agendamento.infra.client.response;

import java.util.List;

public record VacinaResponse(
    Long id,
    List<LoteVacinaResponse> lotes
) {
}
