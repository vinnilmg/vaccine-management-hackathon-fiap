package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindByIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.agendamento.UpdateAgendamentoStatusGateway;
import com.fiap.hackathon.agendamento.application.usecases.CancelarAgendamentoUseCase;
import com.fiap.hackathon.agendamento.domain.exceptions.NotFoundException;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.UpdateAgendamentoStatusDatabaseGateway;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindByIdDatabaseGateway;
import org.springframework.stereotype.Service;

@Service
public class CancelarAgendamentoUseCaseImpl implements CancelarAgendamentoUseCase {
    private final FindByIdGateway findByIdGateway;
    private final UpdateAgendamentoStatusGateway updateAgendamentoStatusGateway;

    public CancelarAgendamentoUseCaseImpl(
            FindByIdDatabaseGateway findByIdGateway,
            UpdateAgendamentoStatusDatabaseGateway updateAgendamentoStatusGateway
    ) {
        this.findByIdGateway = findByIdGateway;
        this.updateAgendamentoStatusGateway = updateAgendamentoStatusGateway;
    }

    @Override
    public void execute(final Long agendamentoId) {
        final var agendamento = findByIdGateway.find(agendamentoId)
                .orElseThrow(NotFoundException::ofAgendamento);

        agendamento.cancelar();
        updateAgendamentoStatusGateway.update(agendamento);
    }
}
