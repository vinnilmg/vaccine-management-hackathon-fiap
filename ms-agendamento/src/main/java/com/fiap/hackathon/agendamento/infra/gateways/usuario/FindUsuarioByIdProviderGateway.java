package com.fiap.hackathon.agendamento.infra.gateways.usuario;

import com.fiap.hackathon.agendamento.application.gateway.usuario.FindUsuarioByIdGateway;
import com.fiap.hackathon.agendamento.domain.entities.usuario.Usuario;
import com.fiap.hackathon.agendamento.infra.client.UsuarioClient;
import com.fiap.hackathon.agendamento.infra.client.mappers.UsuarioResponseMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class FindUsuarioByIdProviderGateway implements FindUsuarioByIdGateway {
    private final UsuarioClient usuarioClient;
    private final UsuarioResponseMapper usuarioResponseMapper;

    public FindUsuarioByIdProviderGateway(UsuarioClient usuarioClient, UsuarioResponseMapper usuarioResponseMapper) {
        this.usuarioClient = usuarioClient;
        this.usuarioResponseMapper = usuarioResponseMapper;
    }

    @Override
    public Optional<Usuario> find(final Long id) {
        log.info("Buscando usuário no microsserviço...");
        try {
            return Optional.ofNullable(usuarioClient.getUsuarioById(id))
                    .map(usuarioResponseMapper::toDomain);
        } catch (FeignException e) {
            if (e.status() != HttpStatus.NOT_FOUND.value()) {
                throw e;
            }
        }
        return Optional.empty();
    }
}
