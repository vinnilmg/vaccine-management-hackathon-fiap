package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina.lote.Lote;

import java.util.List;

public interface Vacina {
    Long getId();

    List<Lote> getLotes();
}
