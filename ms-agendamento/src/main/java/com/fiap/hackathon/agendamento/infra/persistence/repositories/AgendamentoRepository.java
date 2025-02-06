package com.fiap.hackathon.agendamento.infra.persistence.repositories;

import com.fiap.hackathon.agendamento.infra.persistence.entities.AgendamentoEntity;
import com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
    List<AgendamentoEntity> findByPostoVacinacaoId(Long postoVacinacaoId);

    List<AgendamentoEntity> findByUsuarioId(Long usuarioId);

    List<AgendamentoEntity> findByVacinaId(Long vacinaId);

    Optional<AgendamentoEntity> findByUsuarioIdAndVacinaIdAndStatus(
            Long usuarioId,
            Long vacinaId,
            StatusAgendamento status
    );
}
