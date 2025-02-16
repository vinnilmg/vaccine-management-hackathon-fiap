package com.fiap.hackathon.agendamento.infra.client.response.posto.vacinacao.lote;

public record LoteVacinaResponse(
        Long id,
        String numero,
        Long postoVacinacaoId,
        Long vacinaId,
        Integer estoque,
        String validade
) {
}
