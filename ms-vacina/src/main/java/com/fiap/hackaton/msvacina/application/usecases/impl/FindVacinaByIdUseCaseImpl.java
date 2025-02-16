package com.fiap.hackaton.msvacina.application.usecases.impl;

import com.fiap.hackaton.msvacina.application.gateway.VacinaGateway;
import com.fiap.hackaton.msvacina.application.usecases.FindVacinaByIdUseCase;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

import java.util.Optional;
import java.util.UUID;


public class FindVacinaByIdUseCaseImpl  implements FindVacinaByIdUseCase {

    private final VacinaGateway vacinaGateway;

    public FindVacinaByIdUseCaseImpl(VacinaGateway vacinaGateway) {
        this.vacinaGateway = vacinaGateway;
    }

    @Override
    public Optional<VacinaDomain> findById(UUID id) {
        return vacinaGateway.findVacinaById(id);
    }
}
