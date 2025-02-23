package com.fiap.hackaton.msvacina.application.usecases;

import java.util.UUID;

@FunctionalInterface
public interface DeleteVacinaUseCase {

    void delete(Long id);
}
