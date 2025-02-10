package com.fiap.hackathon.agendamento.infra.gateways.agendamento;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindByVacinaGateway;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.persistence.mappers.AgendamentoEntityMapper;
import com.fiap.hackathon.agendamento.infra.persistence.repositories.AgendamentoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindByVacinaDatabaseGateway implements FindByVacinaGateway {
    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoEntityMapper agendamentoEntityMapper;

    public FindByVacinaDatabaseGateway(
            AgendamentoRepository agendamentoRepository,
            AgendamentoEntityMapper agendamentoEntityMapper
    ) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoEntityMapper = agendamentoEntityMapper;
    }

    @Override
    public List<Agendamento> find(final Long vacinaId) {
        final var agendamentos = agendamentoRepository.findByVacinaId(vacinaId);
        return agendamentoEntityMapper.toAgendamentosDomain(agendamentos);
    }
}
