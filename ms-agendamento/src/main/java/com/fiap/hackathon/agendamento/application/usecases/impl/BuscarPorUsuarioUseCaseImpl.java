package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindByUsuarioGateway;
import com.fiap.hackathon.agendamento.application.usecases.BuscarPorUsuarioUseCase;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindByUsuarioDatabaseGateway;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException.ofNullOrLessThanZero;
import static com.fiap.hackathon.agendamento.utils.ValidationUtils.isNullOrLessThanZero;

@Service
public class BuscarPorUsuarioUseCaseImpl implements BuscarPorUsuarioUseCase {
    private final FindByUsuarioGateway findByUsuarioGateway;

    public BuscarPorUsuarioUseCaseImpl(FindByUsuarioDatabaseGateway findByUsuarioGateway) {
        this.findByUsuarioGateway = findByUsuarioGateway;
    }

    @Override
    public List<Agendamento> execute(final Long usuarioId) {
        if (isNullOrLessThanZero().test(usuarioId)) throw ofNullOrLessThanZero("Usuario Id");
        return findByUsuarioGateway.find(usuarioId);
    }
}
