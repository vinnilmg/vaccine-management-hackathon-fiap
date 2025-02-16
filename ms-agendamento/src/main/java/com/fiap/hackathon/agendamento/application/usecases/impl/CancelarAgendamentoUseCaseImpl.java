package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindByIdGateway;
import com.fiap.hackathon.agendamento.application.gateway.agendamento.UpdateAgendamentoStatusGateway;
import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.IncreaseStockByPostoVacinacaoAndVacinaIdGateway;
import com.fiap.hackathon.agendamento.application.usecases.CancelarAgendamentoUseCase;
import com.fiap.hackathon.agendamento.domain.exceptions.NotFoundException;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindByIdDatabaseGateway;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.UpdateAgendamentoStatusDatabaseGateway;
import com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao.IncreaseStockByPostoVacinacaoAndVacinaIdProviderGateway;
import org.springframework.stereotype.Service;

@Service
public class CancelarAgendamentoUseCaseImpl implements CancelarAgendamentoUseCase {
    private final FindByIdGateway findByIdGateway;
    private final UpdateAgendamentoStatusGateway updateAgendamentoStatusGateway;
    private final IncreaseStockByPostoVacinacaoAndVacinaIdGateway increaseStockByPostoVacinacaoAndVacinaIdGateway;

    public CancelarAgendamentoUseCaseImpl(
            FindByIdDatabaseGateway findByIdGateway,
            UpdateAgendamentoStatusDatabaseGateway updateAgendamentoStatusGateway,
            IncreaseStockByPostoVacinacaoAndVacinaIdProviderGateway increaseStockByLoteIdGateway
    ) {
        this.findByIdGateway = findByIdGateway;
        this.updateAgendamentoStatusGateway = updateAgendamentoStatusGateway;
        this.increaseStockByPostoVacinacaoAndVacinaIdGateway = increaseStockByLoteIdGateway;
    }

    @Override
    public void execute(final Long agendamentoId) {
        final var agendamento = findByIdGateway.find(agendamentoId)
                .orElseThrow(NotFoundException::ofAgendamento);

        agendamento.cancelar();

        increaseStockByPostoVacinacaoAndVacinaIdGateway.increase(
                agendamento.getPostoVacinacaoId(),
                agendamento.getVacinaId()
        );

        updateAgendamentoStatusGateway.update(agendamento);
    }
}
