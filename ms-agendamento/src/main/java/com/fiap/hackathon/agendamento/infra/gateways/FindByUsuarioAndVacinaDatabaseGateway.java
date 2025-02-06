package com.fiap.hackathon.agendamento.infra.gateways;

import com.fiap.hackathon.agendamento.application.gateway.FindByUsuarioAndVacinaGateway;
import com.fiap.hackathon.agendamento.domain.entities.Agendamento;
import com.fiap.hackathon.agendamento.infra.persistence.mappers.AgendamentoEntityMapper;
import com.fiap.hackathon.agendamento.infra.persistence.repositories.AgendamentoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento.CONFIRMADO;

@Component
public class FindByUsuarioAndVacinaDatabaseGateway implements FindByUsuarioAndVacinaGateway {
    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoEntityMapper agendamentoEntityMapper;

    public FindByUsuarioAndVacinaDatabaseGateway(
            AgendamentoRepository agendamentoRepository,
            AgendamentoEntityMapper agendamentoEntityMapper
    ) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoEntityMapper = agendamentoEntityMapper;
    }

    @Override
    public Optional<Agendamento> find(final Long usuarioId, final Long vacinaId) {
        return agendamentoRepository.findByUsuarioIdAndVacinaIdAndStatus(usuarioId, vacinaId, CONFIRMADO)
                .map(agendamentoEntityMapper::toAgendamentoDomain);
    }
}
