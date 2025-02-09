package com.fiap.hackathon.agendamento.infra.gateways.agendamento;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindByPostoVacinacaoGateway;
import com.fiap.hackathon.agendamento.domain.entities.Agendamento;
import com.fiap.hackathon.agendamento.infra.persistence.mappers.AgendamentoEntityMapper;
import com.fiap.hackathon.agendamento.infra.persistence.repositories.AgendamentoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindByPostoVacinacaoDatabaseGateway implements FindByPostoVacinacaoGateway {
    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoEntityMapper agendamentoEntityMapper;

    public FindByPostoVacinacaoDatabaseGateway(
            AgendamentoRepository agendamentoRepository,
            AgendamentoEntityMapper agendamentoEntityMapper
    ) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoEntityMapper = agendamentoEntityMapper;
    }

    @Override
    public List<Agendamento> find(final Long postoVacinacaoId) {
        final var agendamentos = agendamentoRepository.findByPostoVacinacaoId(postoVacinacaoId);
        return agendamentoEntityMapper.toAgendamentosDomain(agendamentos);
    }
}
