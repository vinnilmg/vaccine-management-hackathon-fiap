package com.fiap.hackathon.agendamento.application.usecases;

@FunctionalInterface
public interface CancelarAgendamentoUseCase {
    void execute(Long agendamentoId);
}
