package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.CreateAgendamentoGateway;
import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindConfirmedByUsuarioAndVacinaGateway;
import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.FindPostoVacinacaoByIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.usuario.FindHistoricoVacinacaoByUsuarioAndVacinaIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.usuario.FindUsuarioByIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.vacina.FindVacinaByIdGateway;
import com.fiap.hackathon.agendamento.application.usecases.CriarAgendamentoUseCase;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.domain.exceptions.AgendamentoAlreayExistsException;
import com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException;
import com.fiap.hackathon.agendamento.domain.exceptions.NotFoundException;
import com.fiap.hackathon.agendamento.infra.controllers.mappers.AgendamentoRequestMapper;
import com.fiap.hackathon.agendamento.infra.controllers.request.AgendamentoRequest;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.CreateAgendamentoDatabaseGateway;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindConfirmedByUsuarioAndVacinaDatabaseGateway;
import com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao.FindPostoVacinacaoByIdProviderGateway;
import com.fiap.hackathon.agendamento.infra.gateways.usuario.FindHistoricoVacinacaoByUsuarioAndVacinaIdProviderGateway;
import com.fiap.hackathon.agendamento.infra.gateways.usuario.FindUsuarioByIdProviderGateway;
import com.fiap.hackathon.agendamento.infra.gateways.vacina.FindVacinaByIdProviderGateway;
import org.springframework.stereotype.Service;

@Service
public class CriarAgendamentoUseCaseImpl implements CriarAgendamentoUseCase {
    private final FindConfirmedByUsuarioAndVacinaGateway findConfirmedByUsuarioAndVacinaGateway;
    private final FindUsuarioByIdGateway findUsuarioByIdGateway;
    private final FindPostoVacinacaoByIdGateway findPostoVacinacaoByIdGateway;
    private final AgendamentoRequestMapper agendamentoRequestMapper;
    private final CreateAgendamentoGateway createAgendamentoGateway;
    private final FindHistoricoVacinacaoByUsuarioAndVacinaIdGateway findHistoricoVacinacaoByUsuarioAndVacinaIdGateway;
    private final FindVacinaByIdGateway findVacinaByIdGateway;

    public CriarAgendamentoUseCaseImpl(
            FindConfirmedByUsuarioAndVacinaDatabaseGateway findByUsuarioAndVacinaGateway,
            FindUsuarioByIdProviderGateway findUsuarioByIdGateway,
            FindPostoVacinacaoByIdProviderGateway findPostoVacinacaoByIdGateway,
            AgendamentoRequestMapper agendamentoRequestMapper,
            CreateAgendamentoDatabaseGateway createAgendamentoGateway,
            FindHistoricoVacinacaoByUsuarioAndVacinaIdProviderGateway findHistoricoVacinacaoByUsuarioAndVacinaIdGateway,
            FindVacinaByIdProviderGateway findVacinaByIdGateway
    ) {
        this.findConfirmedByUsuarioAndVacinaGateway = findByUsuarioAndVacinaGateway;
        this.findUsuarioByIdGateway = findUsuarioByIdGateway;
        this.findPostoVacinacaoByIdGateway = findPostoVacinacaoByIdGateway;
        this.agendamentoRequestMapper = agendamentoRequestMapper;
        this.createAgendamentoGateway = createAgendamentoGateway;
        this.findHistoricoVacinacaoByUsuarioAndVacinaIdGateway = findHistoricoVacinacaoByUsuarioAndVacinaIdGateway;
        this.findVacinaByIdGateway = findVacinaByIdGateway;
    }

    @Override
    public Agendamento execute(final AgendamentoRequest request) {
        findConfirmedByUsuarioAndVacinaGateway.find(request.usuarioId(), request.vacinaId())
                .ifPresent(a -> {
                    throw AgendamentoAlreayExistsException.of();
                });

        final var usuario = findUsuarioByIdGateway.find(request.usuarioId())
                .orElseThrow(NotFoundException::ofUsuario);

        final var postoVacinacao = findPostoVacinacaoByIdGateway.find(request.postoVacinacaoId())
                .orElseThrow(NotFoundException::ofPostoVacinacao);

        if (postoVacinacao.isClosed(request.dataHoraAgendamento())) {
            throw new CustomValidationException("Posto de Vacinação", "fechado no dia ou horário solicitado");
        }

        final var vacina = findVacinaByIdGateway.find(request.vacinaId())
                .orElseThrow(NotFoundException::ofVacina);

        final var historico = findHistoricoVacinacaoByUsuarioAndVacinaIdGateway.find(request.usuarioId(), request.vacinaId());
        usuario.putHistorico(historico);

        if (usuario.isCannotGetAVaccine(vacina, request.dataHoraAgendamento())) {
            throw new CustomValidationException("Usuario", "não pode tomar uma nova dose, pois a última dose ainda não venceu");
        }

        // TODO: Verificar se tem estoque da vacina no posto

        return createAgendamentoGateway.create(agendamentoRequestMapper.toDomain(request));
    }
}
