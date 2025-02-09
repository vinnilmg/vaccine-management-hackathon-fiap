package com.fiap.hackathon.agendamento.application.gateway.agendamento;

import com.fiap.hackathon.agendamento.domain.entities.Agendamento;

@FunctionalInterface
public interface UpdateAgendamentoStatusGateway {
    void update(Agendamento agendamento);
}
