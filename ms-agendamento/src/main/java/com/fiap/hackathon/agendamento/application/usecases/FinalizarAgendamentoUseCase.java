package com.fiap.hackathon.agendamento.application.usecases;

@FunctionalInterface
public interface FinalizarAgendamentoUseCase {
    void execute(Long agendamentoId);
}
