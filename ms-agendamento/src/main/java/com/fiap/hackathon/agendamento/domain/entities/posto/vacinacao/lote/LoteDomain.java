package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.lote;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.requireNonNull;

public class LoteDomain implements Lote {
    private final Long id;
    private final String numero;
    private final Long postoVacinacaoId;
    private final Long vacinaId;
    private final LocalDate validade;
    private final Integer estoque;

    public LoteDomain(
            final Long id,
            final String numero,
            final Long postoVacinacaoId,
            final Long vacinaId,
            final String dataValidade,
            final Integer estoque
    ) {
        this.id = requireNonNull(id, "Lote Id cannot be null");
        this.numero = requireNonNull(numero, "Numero cannot be null");
        this.postoVacinacaoId = requireNonNull(postoVacinacaoId, "Posto Vacinacao Id cannot be null");
        this.vacinaId = requireNonNull(vacinaId, "Vacina Id cannot be null");

        requireNonNull(dataValidade, "Data Validade cannot be null");
        this.validade = LocalDate.parse(dataValidade, ofPattern("yyyy-MM-dd"));

        this.estoque = requireNonNull(estoque, "Estoque cannot be null");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public Long getPostoVacinacaoId() {
        return postoVacinacaoId;
    }

    @Override
    public Long getVacinaId() {
        return vacinaId;
    }

    @Override
    public LocalDate getValidade() {
        return validade;
    }

    @Override
    public Integer getEstoque() {
        return estoque;
    }

    @Override
    public boolean containsEstoque() {
        return estoque > 0;
    }
}
