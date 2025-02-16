package com.fiap.hackathon.agendamento.application.gateway.usuario;

import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;

@FunctionalInterface
public interface CreateHistoricoVacinacaoGateway {
    void create(Agendamento agendamento);
}
