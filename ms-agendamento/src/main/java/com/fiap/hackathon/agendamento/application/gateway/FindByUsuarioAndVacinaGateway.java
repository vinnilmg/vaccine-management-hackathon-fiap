package com.fiap.hackathon.agendamento.application.gateway;

import com.fiap.hackathon.agendamento.domain.entities.Agendamento;

import java.util.Optional;

@FunctionalInterface
public interface FindByUsuarioAndVacinaGateway {
    Optional<Agendamento> find(Long usuarioId, Long vacinaId);
}
