package com.fiap.hackathon.agendamento.application.gateway.usuario;

import com.fiap.hackathon.agendamento.domain.entities.usuario.UsuarioComHistorico;

import java.util.Optional;

@FunctionalInterface
public interface FindUsuarioByIdGateway {
    Optional<UsuarioComHistorico> find(Long id);
}
