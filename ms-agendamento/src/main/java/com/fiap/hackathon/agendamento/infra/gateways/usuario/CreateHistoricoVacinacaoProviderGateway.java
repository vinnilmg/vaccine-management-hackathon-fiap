package com.fiap.hackathon.agendamento.infra.gateways.usuario;

import com.fiap.hackathon.agendamento.application.gateway.usuario.CreateHistoricoVacinacaoGateway;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.client.UsuarioClient;
import com.fiap.hackathon.agendamento.infra.client.mappers.request.CreateHistoricoVacinacaoRequestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateHistoricoVacinacaoProviderGateway implements CreateHistoricoVacinacaoGateway {
    private final UsuarioClient usuarioClient;
    private final CreateHistoricoVacinacaoRequestMapper createHistoricoVacinacaoRequestMapper;

    public CreateHistoricoVacinacaoProviderGateway(
            UsuarioClient usuarioClient,
            CreateHistoricoVacinacaoRequestMapper createHistoricoVacinacaoRequestMapper
    ) {
        this.usuarioClient = usuarioClient;
        this.createHistoricoVacinacaoRequestMapper = createHistoricoVacinacaoRequestMapper;
    }

    @Override
    public void create(final Agendamento agendamento) {
        log.info("Criando histórico de vacinação no microsserviço...");
        final var request = createHistoricoVacinacaoRequestMapper.toRequest(agendamento);
        usuarioClient.createHistoricoVacinacao(request);
    }
}
