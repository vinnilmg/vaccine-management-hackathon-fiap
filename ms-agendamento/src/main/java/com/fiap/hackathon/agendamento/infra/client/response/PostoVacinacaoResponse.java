package com.fiap.hackathon.agendamento.infra.client.response;

import java.util.List;

public record PostoVacinacaoResponse(
    Long id,
    String nome,
    String tipo,
    List<FuncionamentoPostoResponse> funcionamento
) {
}
