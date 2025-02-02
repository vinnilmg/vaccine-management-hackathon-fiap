package com.fiap.hackathon.agendamento.infra.persistence.repositories;

import com.fiap.hackathon.agendamento.infra.persistence.entities.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
}
