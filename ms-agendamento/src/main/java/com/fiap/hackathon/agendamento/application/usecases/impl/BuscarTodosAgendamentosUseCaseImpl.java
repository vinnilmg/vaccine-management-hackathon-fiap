package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.usecases.BuscarTodosAgendamentosUseCase;
import com.fiap.hackathon.agendamento.infra.persistence.entities.AgendamentoEntity;
import com.fiap.hackathon.agendamento.infra.persistence.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodosAgendamentosUseCaseImpl implements BuscarTodosAgendamentosUseCase {
    private final AgendamentoRepository agendamentoRepository;

    public BuscarTodosAgendamentosUseCaseImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public List<AgendamentoEntity> execute() {
        return agendamentoRepository.findAll();
    }
}
