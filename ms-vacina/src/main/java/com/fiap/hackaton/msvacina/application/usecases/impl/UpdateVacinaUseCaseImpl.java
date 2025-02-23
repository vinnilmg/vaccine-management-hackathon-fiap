package com.fiap.hackaton.msvacina.application.usecases.impl;

import com.fiap.hackaton.msvacina.application.gateway.VacinaGateway;
import com.fiap.hackaton.msvacina.application.usecases.FindVacinaByIdUseCase;
import com.fiap.hackaton.msvacina.application.usecases.UpdateVacinaUseCase;
import com.fiap.hackaton.msvacina.domain.entities.Vacina;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

public class UpdateVacinaUseCaseImpl implements UpdateVacinaUseCase {

    private final VacinaGateway vacinaGateway;
    private final FindVacinaByIdUseCase findVacinaByIdUseCase;

    public UpdateVacinaUseCaseImpl(VacinaGateway vacinaGateway, FindVacinaByIdUseCase findVacinaByIdUseCase) {
        this.vacinaGateway = vacinaGateway;
        this.findVacinaByIdUseCase = findVacinaByIdUseCase;
    }

    @Override
    public void update(Long id, VacinaDomain vacinaDomain) {
       vacinaGateway.updateVacina(id, vacinaDomain);
    }
}
