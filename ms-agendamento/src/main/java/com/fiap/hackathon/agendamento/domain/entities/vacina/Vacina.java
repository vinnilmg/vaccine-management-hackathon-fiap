package com.fiap.hackathon.agendamento.domain.entities.vacina;

public interface Vacina {
    Long getId();

    String getNome();

    String getFabricante();

    Integer getDoses();

    Integer getIntervalo();
}
