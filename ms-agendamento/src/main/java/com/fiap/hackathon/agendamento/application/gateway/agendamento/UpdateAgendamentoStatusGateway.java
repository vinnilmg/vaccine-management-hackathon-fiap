package com.fiap.hackathon.agendamento.application.gateway.agendamento;

import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;

@FunctionalInterface
public interface UpdateAgendamentoStatusGateway {
    void update(Agendamento agendamento);
}
