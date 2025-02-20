package com.fiap.hackathon.agendamento.infra.gateways.agendamento;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindAllAgendamentosGateway;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
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
