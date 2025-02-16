package com.fiap.hackaton.msvacina.application.usecases.impl;

import com.fiap.hackaton.msvacina.application.gateway.VacinaGateway;
import com.fiap.hackaton.msvacina.application.usecases.CreateVacinaUseCase;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

public class CreateVacinaUseCaseImpl implements CreateVacinaUseCase {

    private final VacinaGateway vacinaGateway;

    public CreateVacinaUseCaseImpl(VacinaGateway vacinaGateway) {
        this.vacinaGateway = vacinaGateway;
    }

    @Override
    public VacinaDomain create(VacinaDomain vacinaDomain) {
        return vacinaGateway.create(vacinaDomain);
    }
}
