package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindConfirmedByUsuarioAndVacinaGateway;
import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.FindPostoVacinacaoByIdGateway;
import com.fiap.hackathon.agendamento.application.usecases.CriarAgendamentoUseCase;
import com.fiap.hackathon.agendamento.domain.entities.Agendamento;
import com.fiap.hackathon.agendamento.domain.exceptions.AgendamentoAlreayExistsException;
import com.fiap.hackathon.agendamento.infra.controllers.request.AgendamentoRequest;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindConfirmedByUsuarioAndVacinaDatabaseGateway;
import com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao.FindPostoVacinacaoByIdProviderGateway;
import org.springframework.stereotype.Service;

@Service
public class CriarAgendamentoUseCaseImpl implements CriarAgendamentoUseCase {
    private final FindConfirmedByUsuarioAndVacinaGateway findConfirmedByUsuarioAndVacinaGateway;
    private final FindPostoVacinacaoByIdGateway findPostoVacinacaoByIdGateway;

    public CriarAgendamentoUseCaseImpl(
            FindConfirmedByUsuarioAndVacinaDatabaseGateway findByUsuarioAndVacinaGateway,
            FindPostoVacinacaoByIdProviderGateway findPostoVacinacaoByIdGateway
    ) {
        this.findConfirmedByUsuarioAndVacinaGateway = findByUsuarioAndVacinaGateway;
        this.findPostoVacinacaoByIdGateway = findPostoVacinacaoByIdGateway;
    }

    @Override
    public Agendamento execute(final AgendamentoRequest request) {
        // TODO: Verificar se já existe um agendamento para o mesmo usuario, com a mesma vacina que esteja pendente
        findConfirmedByUsuarioAndVacinaGateway.find(request.usuarioId(), request.vacinaId())
                .ifPresent(a -> {
                    throw AgendamentoAlreayExistsException.of();
                });

        // TODO: Realizar requisição para validar o usuario
        // TODO: Como verificar se o usuario pode tomar a vacina?
        //agendamento.getUsuarioId();

        // TODO: Realizar requisição para validar o posto de vacinação
        // TODO: Validar horário solicitado para agendamento no local
        // TODO: Verificar se tem estoque da vacina no posto
        findPostoVacinacaoByIdGateway.find(request.postoVacinacaoId());

        return null;
    }
}
