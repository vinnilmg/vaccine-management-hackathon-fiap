package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.FindByUsuarioAndVacinaGateway;
import com.fiap.hackathon.agendamento.application.usecases.CriarAgendamentoUseCase;
import com.fiap.hackathon.agendamento.domain.entities.Agendamento;
import com.fiap.hackathon.agendamento.infra.gateways.FindByUsuarioAndVacinaDatabaseGateway;
import org.springframework.stereotype.Service;

@Service
public class CriarAgendamentoUseCaseImpl implements CriarAgendamentoUseCase {
    private final FindByUsuarioAndVacinaGateway findByUsuarioAndVacinaGateway;

    public CriarAgendamentoUseCaseImpl(FindByUsuarioAndVacinaDatabaseGateway findByUsuarioAndVacinaGateway) {
        this.findByUsuarioAndVacinaGateway = findByUsuarioAndVacinaGateway;
    }

    @Override
    public Agendamento execute(final Agendamento agendamento) {
        // TODO: Verificar se já existe um agendamento para o mesmo usuario, com a mesma vacina que esteja pendente
        findByUsuarioAndVacinaGateway.find(agendamento.getUsuarioId(), agendamento.getVacinaId())
                .ifPresent(a -> {
                    throw new IllegalArgumentException("Ja existe um agendamento confirmado para o mesmo usuario e vacina");
                });

        // TODO: Realizar requisição para validar o usuario
        // TODO: Como verificar se o usuario pode tomar a vacina?
        agendamento.getUsuarioId();

        // TODO: Realizar requisição para validar o posto de vacinação
        // TODO: Validar horário solicitado para agendamento no local
        // TODO: Verificar se tem estoque da vacina no posto
        agendamento.getPostoVacinacaoId();
        agendamento.getVacinaId();

        return null;
    }
}
