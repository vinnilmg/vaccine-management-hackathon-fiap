package com.fiap.hackathon.agendamento.infra.persistence.entities;

import com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataHoraAgendamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @NotNull
    private Long postoVacinacaoId;

    @NotNull
    private Long vacinaId;

    @NotNull
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(@NotNull LocalDateTime dataHoraAgendamento) {
        this.dataHoraAgendamento = dataHoraAgendamento;
    }

    public @NotNull StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(@NotNull StatusAgendamento status) {
        this.status = status;
    }

    public @NotNull Long getPostoVacinacaoId() {
        return postoVacinacaoId;
    }

    public void setPostoVacinacaoId(@NotNull Long postoVacinacaoId) {
        this.postoVacinacaoId = postoVacinacaoId;
    }

    public @NotNull Long getVacinaId() {
        return vacinaId;
    }

    public void setVacinaId(@NotNull Long vacinaId) {
        this.vacinaId = vacinaId;
    }

    public @NotNull Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(@NotNull Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
