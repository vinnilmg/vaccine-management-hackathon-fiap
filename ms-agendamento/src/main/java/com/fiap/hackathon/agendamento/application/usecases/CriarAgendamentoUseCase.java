package com.fiap.hackathon.agendamento.application.usecases;

import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.controllers.request.AgendamentoRequest;

@FunctionalInterface
public interface CriarAgendamentoUseCase {
    Agendamento execute(AgendamentoRequest request);
}
