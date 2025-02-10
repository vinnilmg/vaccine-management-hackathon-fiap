package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina.lote.Lote;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class VacinaDomain implements Vacina {
    private final Long id;
    private final List<Lote> lotes;

    public VacinaDomain(final Long id, final List<Lote> lotes) {
        this.id = requireNonNull(id, "Id cannot be null");
        this.lotes = requireNonNull(lotes, "Lotes cannot be null");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public List<Lote> getLotes() {
        return lotes;
    }
}
