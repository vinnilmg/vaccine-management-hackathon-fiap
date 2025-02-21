package com.fiap.hackathon.agendamento.application.gateway.agendamento;

import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;

import java.util.Optional;

@FunctionalInterface
public interface FindConfirmedByUsuarioAndDifferentVacinaGateway {
    Optional<Agendamento> find(Long usuarioId, Long vacinaId);
}
