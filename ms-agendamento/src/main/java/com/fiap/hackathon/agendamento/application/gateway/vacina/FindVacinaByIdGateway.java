package com.fiap.hackathon.agendamento.application.gateway.vacina;

import com.fiap.hackathon.agendamento.domain.entities.vacina.Vacina;

import java.util.Optional;

@FunctionalInterface
public interface FindVacinaByIdGateway {
    Optional<Vacina> find(Long id);
}
