package com.fiap.hackaton.msvacina.infra.persistence.repositories;

import com.fiap.hackaton.msvacina.infra.persistence.entities.VacinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VacinaRepository extends JpaRepository<VacinaEntity, UUID> {
}
