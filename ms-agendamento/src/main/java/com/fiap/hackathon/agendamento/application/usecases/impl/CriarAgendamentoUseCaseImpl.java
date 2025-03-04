package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.CreateAgendamentoGateway;
import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindConfirmedByUsuarioAndDifferentVacinaGateway;
import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindConfirmedByUsuarioAndVacinaGateway;
import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.DecreaseStockByPostoVacinacaoAndVacinaIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.FindLoteByPostoVacinacaoAndVacinaIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.FindPostoVacinacaoByIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.usuario.FindHistoricoVacinacaoByUsuarioAndVacinaIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.usuario.FindUsuarioByIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.vacina.FindVacinaByIdGateway;
import com.fiap.hackathon.agendamento.application.usecases.CriarAgendamentoUseCase;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException;
import com.fiap.hackathon.agendamento.domain.exceptions.NotFoundException;
import com.fiap.hackathon.agendamento.infra.controllers.mappers.AgendamentoRequestMapper;
import com.fiap.hackathon.agendamento.infra.controllers.request.AgendamentoRequest;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.CreateAgendamentoDatabaseGateway;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindConfirmedByUsuarioAndDifferentVacinaDatabaseGateway;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindConfirmedByUsuarioAndVacinaDatabaseGateway;
import com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao.DecreaseStockByPostoVacinacaoAndVacinaIdProviderGateway;
import com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao.FindLoteByPostoVacinacaoAndVacinaIdProviderGateway;
import com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao.FindPostoVacinacaoByIdProviderGateway;
import com.fiap.hackathon.agendamento.infra.gateways.usuario.FindHistoricoVacinacaoByUsuarioAndVacinaIdProviderGateway;
import com.fiap.hackathon.agendamento.infra.gateways.usuario.FindUsuarioByIdProviderGateway;
import com.fiap.hackathon.agendamento.infra.gateways.vacina.FindVacinaByIdProviderGateway;
import org.springframework.stereotype.Service;

import static com.fiap.hackathon.agendamento.domain.exceptions.AgendamentoAlreadyExistsException.ofAlreadyExistsBySameDay;
import static com.fiap.hackathon.agendamento.domain.exceptions.AgendamentoAlreadyExistsException.ofAlreadyExistsByUserAndVacina;

@Service
public class CriarAgendamentoUseCaseImpl implements CriarAgendamentoUseCase {
    private final FindConfirmedByUsuarioAndVacinaGateway findConfirmedByUsuarioAndVacinaGateway;
    private final FindConfirmedByUsuarioAndDifferentVacinaGateway findConfirmedByUsuarioAndDifferentVacinaGateway;
    private final FindUsuarioByIdGateway findUsuarioByIdGateway;
    private final FindPostoVacinacaoByIdGateway findPostoVacinacaoByIdGateway;
    private final AgendamentoRequestMapper agendamentoRequestMapper;
    private final CreateAgendamentoGateway createAgendamentoGateway;
    private final FindHistoricoVacinacaoByUsuarioAndVacinaIdGateway findHistoricoVacinacaoByUsuarioAndVacinaIdGateway;
    private final FindVacinaByIdGateway findVacinaByIdGateway;
    private final FindLoteByPostoVacinacaoAndVacinaIdGateway findLoteByPostoVacinacaoAndVacinaIdGateway;
    private final DecreaseStockByPostoVacinacaoAndVacinaIdGateway decreaseStockByPostoVacinacaoAndVacinaIdGateway;

    public CriarAgendamentoUseCaseImpl(
            FindConfirmedByUsuarioAndVacinaDatabaseGateway findByUsuarioAndVacinaGateway,
            FindConfirmedByUsuarioAndDifferentVacinaDatabaseGateway findConfirmedByUsuarioAndDifferentVacinaGateway,
            FindUsuarioByIdProviderGateway findUsuarioByIdGateway,
            FindPostoVacinacaoByIdProviderGateway findPostoVacinacaoByIdGateway,
            AgendamentoRequestMapper agendamentoRequestMapper,
            CreateAgendamentoDatabaseGateway createAgendamentoGateway,
            FindHistoricoVacinacaoByUsuarioAndVacinaIdProviderGateway findHistoricoVacinacaoByUsuarioAndVacinaIdGateway,
            FindVacinaByIdProviderGateway findVacinaByIdGateway,
            FindLoteByPostoVacinacaoAndVacinaIdProviderGateway findLoteByPostoVacinacaoAndVacinaIdGateway,
            DecreaseStockByPostoVacinacaoAndVacinaIdProviderGateway decreaseStockByLoteIdGateway
    ) {
        this.findConfirmedByUsuarioAndVacinaGateway = findByUsuarioAndVacinaGateway;
        this.findConfirmedByUsuarioAndDifferentVacinaGateway = findConfirmedByUsuarioAndDifferentVacinaGateway;
        this.findUsuarioByIdGateway = findUsuarioByIdGateway;
        this.findPostoVacinacaoByIdGateway = findPostoVacinacaoByIdGateway;
        this.agendamentoRequestMapper = agendamentoRequestMapper;
        this.createAgendamentoGateway = createAgendamentoGateway;
        this.findHistoricoVacinacaoByUsuarioAndVacinaIdGateway = findHistoricoVacinacaoByUsuarioAndVacinaIdGateway;
        this.findVacinaByIdGateway = findVacinaByIdGateway;
        this.findLoteByPostoVacinacaoAndVacinaIdGateway = findLoteByPostoVacinacaoAndVacinaIdGateway;
        this.decreaseStockByPostoVacinacaoAndVacinaIdGateway = decreaseStockByLoteIdGateway;
    }

    @Override
    public Agendamento execute(final AgendamentoRequest request) {
        findConfirmedByUsuarioAndVacinaGateway.find(request.usuarioId(), request.vacinaId())
                .ifPresent(a -> {
                    throw ofAlreadyExistsByUserAndVacina();
                });

        findConfirmedByUsuarioAndDifferentVacinaGateway.find(request.usuarioId(), request.vacinaId())
                .stream()
                .filter(agendamento -> agendamento.isSameDay(request.dataHoraAgendamento()))
                .findFirst()
                .ifPresent(a -> {
                    throw ofAlreadyExistsBySameDay();
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

        final var historico = findHistoricoVacinacaoByUsuarioAndVacinaIdGateway.find(usuario.getId(), vacina.getId());
        usuario.putHistorico(historico);

        if (usuario.isCannotGetAVaccine(vacina, request.dataHoraAgendamento())) {
            throw new CustomValidationException("Usuario", "não pode tomar uma nova dose, pois a última dose ainda não venceu");
        }

        findLoteByPostoVacinacaoAndVacinaIdGateway.find(postoVacinacao.getId(), vacina.getId())
                .ifPresent(postoVacinacao::putLote);

        if (postoVacinacao.isNoContainsStock(vacina.getId(), request.dataHoraAgendamento())) {
            throw new CustomValidationException("Posto de Vacinação", "não possui estoque para a vacina nesta data");
        }

        final var agendamento = createAgendamentoGateway.create(agendamentoRequestMapper.toDomain(request));

        decreaseStockByPostoVacinacaoAndVacinaIdGateway.decrease(postoVacinacao.getId(), vacina.getId());

        return agendamento;
    }
}
