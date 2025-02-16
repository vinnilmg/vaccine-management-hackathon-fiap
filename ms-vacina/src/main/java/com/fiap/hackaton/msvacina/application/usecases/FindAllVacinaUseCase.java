package com.fiap.hackaton.msvacina.application.usecases;

import com.fiap.hackaton.msvacina.domain.entities.Vacina;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

import java.util.List;

@FunctionalInterface
public interface FindAllVacinaUseCase {

    List<VacinaDomain> findAll();
}
