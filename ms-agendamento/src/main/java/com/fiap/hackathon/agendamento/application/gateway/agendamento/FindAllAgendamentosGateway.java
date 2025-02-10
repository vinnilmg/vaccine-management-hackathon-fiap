package com.fiap.hackathon.agendamento.application.gateway.agendamento;

import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;

import java.util.List;

@FunctionalInterface
public interface FindAllAgendamentosGateway {
    List<Agendamento> find();
}
