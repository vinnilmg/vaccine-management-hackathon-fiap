package com.fiap.hackathon.ms_postos_vacina.controller.request;

public record FuncionamentoRequest(
        String diaSemana,
        String horarioInicio,
        String horarioFim
) {
}
