package com.fiap.hackathon.agendamento.infra.gateways.agendamento;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindConfirmedByUsuarioAndDifferentVacinaGateway;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.persistence.mappers.AgendamentoEntityMapper;
import com.fiap.hackathon.agendamento.infra.persistence.repositories.AgendamentoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento.CONFIRMADO;

@Component
public class FindConfirmedByUsuarioAndDifferentVacinaDatabaseGateway implements FindConfirmedByUsuarioAndDifferentVacinaGateway {
    private final AgendamentoRepository agendamentoRepository;
    private final AgendamentoEntityMapper agendamentoEntityMapper;

    public FindConfirmedByUsuarioAndDifferentVacinaDatabaseGateway(
            AgendamentoRepository agendamentoRepository,
            AgendamentoEntityMapper agendamentoEntityMapper
    ) {
        this.agendamentoRepository = agendamentoRepository;
        this.agendamentoEntityMapper = agendamentoEntityMapper;
    }

    @Override
    public Optional<Agendamento> find(final Long usuarioId, final Long vacinaId) {
        return agendamentoRepository.findByUsuarioIdAndVacinaIdNotAndStatus(usuarioId, vacinaId, CONFIRMADO)
                .map(agendamentoEntityMapper::toAgendamentoDomain);
    }
}
