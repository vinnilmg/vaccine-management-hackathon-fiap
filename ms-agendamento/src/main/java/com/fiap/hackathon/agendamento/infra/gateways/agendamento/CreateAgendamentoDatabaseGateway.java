package com.fiap.hackathon.agendamento.infra.gateways.agendamento;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.CreateAgendamentoGateway;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.persistence.mappers.AgendamentoEntityMapper;
import com.fiap.hackathon.agendamento.infra.persistence.repositories.AgendamentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateAgendamentoDatabaseGateway implements CreateAgendamentoGateway {
    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoEntityMapper agendamentoEntityMapper;

    public CreateAgendamentoDatabaseGateway(
            AgendamentoRepository agendamentoRepository,
            AgendamentoEntityMapper agendamentoEntityMapper
    ) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoEntityMapper = agendamentoEntityMapper;
    }

    @Override
    public Agendamento create(final Agendamento agendamento) {
        log.info("Criando um novo agendamento na base de dados...");
        final var entity = agendamentoEntityMapper.toAgendamentoEntity(agendamento);
        final var saveEntity = agendamentoRepository.save(entity);
        return agendamentoEntityMapper.toAgendamentoDomain(saveEntity);
    }
}
