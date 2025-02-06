package com.fiap.hackathon.agendamento.infra.gateways;

import com.fiap.hackathon.agendamento.application.gateway.FindAllAgendamentosGateway;
import com.fiap.hackathon.agendamento.domain.entities.Agendamento;
import com.fiap.hackathon.agendamento.infra.persistence.mappers.AgendamentoEntityMapper;
import com.fiap.hackathon.agendamento.infra.persistence.repositories.AgendamentoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllAgendamentosDatabaseGateway implements FindAllAgendamentosGateway {
    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoEntityMapper agendamentoEntityMapper;

    public FindAllAgendamentosDatabaseGateway(
            AgendamentoRepository agendamentoRepository,
            AgendamentoEntityMapper agendamentoEntityMapper
    ) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoEntityMapper = agendamentoEntityMapper;
    }

    @Override
    public List<Agendamento> find() {
        final var agendamentos = agendamentoRepository.findAll();
        return agendamentoEntityMapper.toAgendamentosDomain(agendamentos);
    }
}
