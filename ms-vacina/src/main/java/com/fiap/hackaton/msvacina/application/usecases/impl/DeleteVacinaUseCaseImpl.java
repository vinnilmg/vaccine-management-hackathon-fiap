package com.fiap.hackaton.msvacina.application.usecases.impl;

import com.fiap.hackaton.msvacina.application.gateway.VacinaGateway;
import com.fiap.hackaton.msvacina.application.usecases.DeleteVacinaUseCase;
import com.fiap.hackaton.msvacina.application.usecases.FindVacinaByIdUseCase;

import java.util.UUID;

public class DeleteVacinaUseCaseImpl implements DeleteVacinaUseCase {

    private final VacinaGateway vacinaGateway;
    private final FindVacinaByIdUseCase findVacinaByIdUseCase;

    public DeleteVacinaUseCaseImpl(VacinaGateway vacinaGateway, FindVacinaByIdUseCase findVacinaByIdUseCase) {
        this.vacinaGateway = vacinaGateway;
        this.findVacinaByIdUseCase = findVacinaByIdUseCase;
    }

    @Override
    public void delete(UUID id) {
        vacinaGateway.deleteVacina(id);
    }
}
