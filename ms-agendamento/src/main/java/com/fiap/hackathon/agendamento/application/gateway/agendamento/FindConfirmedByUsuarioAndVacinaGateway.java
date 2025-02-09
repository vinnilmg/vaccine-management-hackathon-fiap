package com.fiap.hackathon.agendamento.application.gateway.agendamento;

import com.fiap.hackathon.agendamento.domain.entities.Agendamento;

import java.util.Optional;

@FunctionalInterface
public interface FindConfirmedByUsuarioAndVacinaGateway {
    Optional<Agendamento> find(Long usuarioId, Long vacinaId);
}
