package com.fiap.hackaton.msvacina.application.gateway;

import com.fiap.hackaton.msvacina.domain.entities.Vacina;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface VacinaGateway {

    VacinaDomain create(VacinaDomain vacinaDomain);

    List<VacinaDomain> findAllVacinas();

    Optional<VacinaDomain> findVacinaById(UUID id);

    void updateVacina(UUID id, VacinaDomain vacinaDomain);

    void deleteVacina(UUID id);
}
