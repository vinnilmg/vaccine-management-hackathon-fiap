package com.fiap.hackathon.agendamento.application.gateway.usuario;

import com.fiap.hackathon.agendamento.domain.entities.usuario.Usuario;

import java.util.Optional;

@FunctionalInterface
public interface FindUsuarioByIdGateway {
    Optional<Usuario> find(Long id);
}
