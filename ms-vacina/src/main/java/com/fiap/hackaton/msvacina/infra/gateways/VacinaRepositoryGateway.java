package com.fiap.hackaton.msvacina.infra.gateways;

import com.fiap.hackaton.msvacina.application.gateway.VacinaGateway;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;
import com.fiap.hackaton.msvacina.infra.persistence.entities.VacinaEntity;
import com.fiap.hackaton.msvacina.infra.persistence.repositories.VacinaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VacinaRepositoryGateway implements VacinaGateway {

    private final VacinaRepository vacinaRepository;
    private final ModelMapper modelMapper;

    public VacinaRepositoryGateway(VacinaRepository vacinaRepository, ModelMapper modelMapper) {
        this.vacinaRepository = vacinaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VacinaDomain create(VacinaDomain vacinaDomain) {
        final var entity = modelMapper.map(vacinaDomain, VacinaEntity.class);
        vacinaRepository.save(entity);
        return modelMapper.map(entity, VacinaDomain.class);
    }

    @Override
    public List<VacinaDomain> findAllVacinas() {
        return vacinaRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, VacinaDomain.class))
                .toList();
    }

    @Override
    public Optional<VacinaDomain> findVacinaById(Long id) {
        final var vacina = vacinaRepository.findById(id);
        return vacina.map(entity -> modelMapper.map(entity, VacinaDomain.class));
    }

    @Override
    public void updateVacina(Long id, VacinaDomain vacinaDomain) {
        vacinaRepository.save(modelMapper.map(vacinaDomain, VacinaEntity.class));
    }

    @Override
    public void deleteVacina(Long id) {
        vacinaRepository.deleteById(id);
    }
}
