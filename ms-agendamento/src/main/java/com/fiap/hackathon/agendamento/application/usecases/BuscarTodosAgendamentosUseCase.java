package com.fiap.hackathon.agendamento.application.usecases;

import com.fiap.hackathon.agendamento.infra.persistence.entities.AgendamentoEntity;

import java.util.List;

@FunctionalInterface
public interface BuscarTodosAgendamentosUseCase {
    List<AgendamentoEntity> execute();
}
