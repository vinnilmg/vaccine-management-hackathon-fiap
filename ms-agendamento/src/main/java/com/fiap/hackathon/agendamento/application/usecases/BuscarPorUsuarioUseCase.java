package com.fiap.hackathon.agendamento.application.usecases;

import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;

import java.util.List;

@FunctionalInterface
public interface BuscarPorUsuarioUseCase {
    List<Agendamento> execute(Long usuarioId);
}
