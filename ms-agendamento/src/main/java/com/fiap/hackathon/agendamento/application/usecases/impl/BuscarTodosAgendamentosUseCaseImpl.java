package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindAllAgendamentosGateway;
import com.fiap.hackathon.agendamento.application.usecases.BuscarTodosAgendamentosUseCase;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindAllAgendamentosDatabaseGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodosAgendamentosUseCaseImpl implements BuscarTodosAgendamentosUseCase {
    private final FindAllAgendamentosGateway findAllAgendamentosGateway;

    public BuscarTodosAgendamentosUseCaseImpl(FindAllAgendamentosDatabaseGateway findAllAgendamentos) {
        this.findAllAgendamentosGateway = findAllAgendamentos;
    }

    @Override
    public List<Agendamento> execute() {
        return findAllAgendamentosGateway.find();
    }
}
