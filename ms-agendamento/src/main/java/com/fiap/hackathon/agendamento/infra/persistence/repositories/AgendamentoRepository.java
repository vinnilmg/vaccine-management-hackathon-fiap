package com.fiap.hackathon.agendamento.infra.persistence.repositories;

import com.fiap.hackathon.agendamento.infra.persistence.entities.AgendamentoEntity;
import com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    Optional<AgendamentoEntity> findByUsuarioIdAndVacinaIdNotAndStatus(
            Long usuarioId,
            Long vacinaId,
            StatusAgendamento status
    );

    @Transactional
    @Modifying
    @Query("update AgendamentoEntity a set a.status = :status where a.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") StatusAgendamento status);
}
