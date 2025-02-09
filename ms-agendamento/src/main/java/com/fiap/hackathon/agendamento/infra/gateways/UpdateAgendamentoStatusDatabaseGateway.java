package com.fiap.hackathon.agendamento.infra.gateways;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.UpdateAgendamentoStatusGateway;
import com.fiap.hackathon.agendamento.domain.entities.Agendamento;
import com.fiap.hackathon.agendamento.infra.persistence.repositories.AgendamentoRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateAgendamentoStatusDatabaseGateway implements UpdateAgendamentoStatusGateway {
    private final AgendamentoRepository agendamentoRepository;

    public UpdateAgendamentoStatusDatabaseGateway(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public void update(final Agendamento agendamento) {
        agendamentoRepository.updateStatus(agendamento.getId(), agendamento.getStatusEnum());
    }
}
