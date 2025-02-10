package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina.lote;

public interface Lote {
    Long getId();

    String getCodigo();

    Integer getEstoque();

    String getValidade();
}
