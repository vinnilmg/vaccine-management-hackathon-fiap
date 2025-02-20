package com.fiap.hackathon.agendamento.application.usecases.impl;

import com.fiap.hackathon.agendamento.application.gateway.agendamento.FindByPostoVacinacaoGateway;
import com.fiap.hackathon.agendamento.application.usecases.BuscarPorPostoVacinacaoUseCase;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.gateways.agendamento.FindByPostoVacinacaoDatabaseGateway;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException.ofNullOrLessThanZero;
import static com.fiap.hackathon.agendamento.utils.ValidationUtils.isNullOrLessThanZero;

@Service
public class BuscarPorPostoVacinacaoUseCaseImpl implements BuscarPorPostoVacinacaoUseCase {
    private final FindByPostoVacinacaoGateway findByPostoVacinacaoGateway;

    public BuscarPorPostoVacinacaoUseCaseImpl(FindByPostoVacinacaoDatabaseGateway findByPostoVacinacaoGateway) {
        this.findByPostoVacinacaoGateway = findByPostoVacinacaoGateway;
    }

    @Override
    public List<Agendamento> execute(final Long postoVacinacaoId) {
        if (isNullOrLessThanZero().test(postoVacinacaoId)) throw ofNullOrLessThanZero("Posto Vacinacao Id");
        return findByPostoVacinacaoGateway.find(postoVacinacaoId);
    }
}
