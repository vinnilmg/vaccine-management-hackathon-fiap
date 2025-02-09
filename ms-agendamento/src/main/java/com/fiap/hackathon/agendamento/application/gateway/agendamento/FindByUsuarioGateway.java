package com.fiap.hackathon.agendamento.application.gateway.agendamento;

import com.fiap.hackathon.agendamento.domain.entities.Agendamento;

import java.util.List;

@FunctionalInterface
public interface FindByUsuarioGateway {
    List<Agendamento> find(Long usuarioId);
}
