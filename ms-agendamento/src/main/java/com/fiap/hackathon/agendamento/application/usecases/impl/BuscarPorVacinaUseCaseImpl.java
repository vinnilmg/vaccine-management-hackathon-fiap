package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindByVacinaGateway;
import com.fiap.hackathon.agendamento.application.usecases.BuscarPorVacinaUseCase;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindByVacinaDatabaseGateway;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException.ofNullOrLessThanZero;
import static com.fiap.hackathon.agendamento.utils.ValidationUtils.isNullOrLessThanZero;

@Service
public class BuscarPorVacinaUseCaseImpl implements BuscarPorVacinaUseCase {
    private final FindByVacinaGateway findByVacinaGateway;

    public BuscarPorVacinaUseCaseImpl(FindByVacinaDatabaseGateway findByVacinaGateway) {
        this.findByVacinaGateway = findByVacinaGateway;
    }

    @Override
    public List<Agendamento> execute(final Long vacinaId) {
        if (isNullOrLessThanZero().test(vacinaId)) throw ofNullOrLessThanZero("Vacina Id");
        return findByVacinaGateway.find(vacinaId);
    }
}
