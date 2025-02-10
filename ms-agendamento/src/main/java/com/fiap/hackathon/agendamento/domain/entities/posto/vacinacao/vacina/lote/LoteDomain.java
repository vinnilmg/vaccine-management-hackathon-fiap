package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina.lote;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.requireNonNull;

public class LoteDomain implements Lote {
    private final Long id;
    private final String codigo;
    private Integer estoque;
    private LocalDate dataValidade;

    public LoteDomain(
            final Long id,
            final String codigo,
            final Integer estoque,
            final String dataValidade
    ) {
        this.id = requireNonNull(id, "Lote Id cannot be null");
        this.codigo = requireNonNull(codigo, "Codigo cannot be null");
        this.estoque = requireNonNull(estoque, "Estoque cannot be null");
        requireNonNull(dataValidade, "Data Validade cannot be null");
        this.dataValidade = LocalDate.parse(dataValidade, ofPattern("dd/MM/yyyy"));
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public Integer getEstoque() {
        return estoque;
    }

    @Override
    public String getValidade() {
        return dataValidade.toString();
    }
}
