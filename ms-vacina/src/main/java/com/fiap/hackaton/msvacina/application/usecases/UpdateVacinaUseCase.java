package com.fiap.hackaton.msvacina.application.usecases;

import com.fiap.hackaton.msvacina.domain.entities.Vacina;

@FunctionalInterface
public interface UpdateVacinaUseCase {

    Vacina update(Long id, Vacina vacina);
}
