package com.fiap.hackathon.agendamento.domain.entities.agendamento;

import com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento;

import java.time.LocalDateTime;

public interface Agendamento {
    Long getId();

    Long getUsuarioId();

    Long getPostoVacinacaoId();

    Long getVacinaId();

    String getStatus();

    StatusAgendamento getStatusEnum();

    String getData();

    String getDataFormatada();

    String getHora();

    String getDataHora();

    void cancelar();

    void finalizar();

    boolean isSameDay(LocalDateTime dataAgendamento);
}
