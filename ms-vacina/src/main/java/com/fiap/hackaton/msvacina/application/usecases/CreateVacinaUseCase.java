package com.fiap.hackaton.msvacina.application.usecases;

import com.fiap.hackaton.msvacina.domain.entities.Vacina;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

@FunctionalInterface
public interface CreateVacinaUseCase {

    VacinaDomain create(VacinaDomain vacinaDomain);
}
