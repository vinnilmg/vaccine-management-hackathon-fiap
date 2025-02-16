package com.fiap.hackathon.agendamento.domain.entities.vacina;

import static java.util.Objects.requireNonNull;

public class VacinaDomain implements Vacina {
    private final Long id;
    private final String nome;
    private final String fabricante;
    private final Integer doses;
    private final Integer intervalo;

    public VacinaDomain(
            final Long id,
            final String nome,
            final String fabricante,
            final Integer doses,
            final Integer intervalo
    ) {
        this.id = requireNonNull(id, "Id cannot be null");
        this.nome = requireNonNull(nome, "Nome cannot be null");
        this.fabricante = requireNonNull(fabricante, "Fabricante cannot be null");
        this.doses = requireNonNull(doses, "Doses cannot be null");
        this.intervalo = requireNonNull(intervalo, "Intervalo cannot be null");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getFabricante() {
        return fabricante;
    }

    @Override
    public Integer getDoses() {
        return doses;
    }

    @Override
    public Integer getIntervalo() {
        return intervalo;
    }
}
