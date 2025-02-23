package com.fiap.hackaton.msvacina.application.gateway;

import com.fiap.hackaton.msvacina.domain.entities.Vacina;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface VacinaGateway {

    VacinaDomain create(VacinaDomain vacinaDomain);

    List<VacinaDomain> findAllVacinas();

    Optional<VacinaDomain> findVacinaById(Long id);

    void updateVacina(Long id, VacinaDomain vacinaDomain);

    void deleteVacina(Long id);
}
