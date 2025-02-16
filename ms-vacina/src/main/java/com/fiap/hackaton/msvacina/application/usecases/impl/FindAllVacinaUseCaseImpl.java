package com.fiap.hackaton.msvacina.application.usecases.impl;

import com.fiap.hackaton.msvacina.application.gateway.VacinaGateway;
import com.fiap.hackaton.msvacina.application.usecases.FindAllVacinaUseCase;
import com.fiap.hackaton.msvacina.domain.entities.Vacina;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

import java.util.List;

public class FindAllVacinaUseCaseImpl implements FindAllVacinaUseCase {

    private final VacinaGateway vacinaGateway;

    public FindAllVacinaUseCaseImpl(VacinaGateway vacinaGateway) {
        this.vacinaGateway = vacinaGateway;
    }

    @Override
    public List<VacinaDomain> findAll() {
        return vacinaGateway.findAllVacinas();
    }
}
