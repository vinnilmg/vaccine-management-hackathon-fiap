package com.fiap.hackathon.agendamento.domain.entities;

import com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento;

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
}
