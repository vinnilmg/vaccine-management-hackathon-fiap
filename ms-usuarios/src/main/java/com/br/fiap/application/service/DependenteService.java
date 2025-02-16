package com.br.fiap.application.service;

import com.br.fiap.application.dto.request.DependenteRequest;
import com.br.fiap.core.model.Dependente;

import java.util.List;

public interface DependenteService {

    List<Dependente> getAllDependentes();

    Dependente getDependenteById(Long id);

    Dependente create(DependenteRequest dependenteModel);

    Dependente update(Long id, DependenteRequest dependenteModel);

    void delete(Long id);
}
