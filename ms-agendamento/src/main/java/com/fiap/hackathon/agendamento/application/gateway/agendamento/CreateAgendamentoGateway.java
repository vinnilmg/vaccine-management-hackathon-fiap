package com.fiap.hackathon.agendamento.application.gateway.agendamento;

import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;

@FunctionalInterface
public interface CreateAgendamentoGateway {
    Agendamento create(Agendamento agendamento);
}
