package com.fiap.hackathon.agendamento.domain.entities;

public interface Agendamento {
    Long getId();

    Long getUsuarioId();

    Long getPostoVacinacaoId();

    Long getVacinaId();

    String getStatus();

    String getData();

    String getHora();

    String getDataHora();
}
