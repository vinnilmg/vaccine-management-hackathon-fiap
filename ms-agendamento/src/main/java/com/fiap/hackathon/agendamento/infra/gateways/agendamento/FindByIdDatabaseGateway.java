package com.fiap.hackathon.agendamento.infra.gateways.agendamento;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindByIdGateway;
import com.fiap.hackathon.agendamento.domain.entities.Agendamento;
import com.fiap.hackathon.agendamento.infra.persistence.mappers.AgendamentoEntityMapper;
import com.fiap.hackathon.agendamento.infra.persistence.repositories.AgendamentoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindByIdDatabaseGateway implements FindByIdGateway {
    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoEntityMapper agendamentoEntityMapper;

    public FindByIdDatabaseGateway(
            AgendamentoRepository agendamentoRepository,
            AgendamentoEntityMapper agendamentoEntityMapper
    ) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoEntityMapper = agendamentoEntityMapper;
    }

    @Override
    public Optional<Agendamento> find(final Long agendamentoId) {
        return agendamentoRepository.findById(agendamentoId)
                .map(agendamentoEntityMapper::toAgendamentoDomain);
    }
}
