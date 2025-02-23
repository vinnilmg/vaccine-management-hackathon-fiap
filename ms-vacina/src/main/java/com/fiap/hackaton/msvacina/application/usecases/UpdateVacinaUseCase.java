package com.fiap.hackaton.msvacina.application.usecases;

import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

@FunctionalInterface
public interface UpdateVacinaUseCase {

    void update(Long id, VacinaDomain vacinaDomain);
}
