package com.fiap.hackathon.agendamento.infra.persistence.repositories;

import com.fiap.hackathon.agendamento.infra.persistence.entities.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
    List<AgendamentoEntity> findByPostoVacinacaoId(Long postoVacinacaoId);

    List<AgendamentoEntity> findByUsuarioId(Long usuarioId);

    List<AgendamentoEntity> findByVacinaId(Long vacinaId);
}
