package com.fiap.hackaton.msvacina.application.usecases;

import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

import java.util.Optional;
import java.util.UUID;

@FunctionalInterface
public interface FindVacinaByIdUseCase {

    Optional<VacinaDomain> findById(UUID id);
}
