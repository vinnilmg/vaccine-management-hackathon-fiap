package com.fiap.hackathon.agendamento.application.usecases;

import com.fiap.hackathon.agendamento.domain.entities.Agendamento;

@FunctionalInterface
public interface CriarAgendamentoUseCase {
    Agendamento execute(Agendamento agendamento);
}
