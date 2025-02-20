package com.fiap.hackathon.agendamento.domain.entities.usuario.historico;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.requireNonNull;

public class HistoricoVacinacaoDomain implements HistoricoVacinacao {
    private final Long id;
    private final Long vacinaId;
    private final Long postoVacinacaoId;
    private final LocalDate data;

    public HistoricoVacinacaoDomain(
            final Long id,
            final Long vacinaId,
            final Long postoVacinacaoId,
            final String data
    ) {
        this.id = requireNonNull(id, "Id cannot be null");
        this.vacinaId = requireNonNull(vacinaId, "Vacina Id cannot be null");
        this.postoVacinacaoId = requireNonNull(postoVacinacaoId, "Posto Vacinacao Id cannot be null");
        this.data = LocalDate.parse(data, ofPattern("yyyy-MM-dd"));
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getVacinaId() {
        return vacinaId;
    }

    @Override
    public Long getPostoVacinacaoId() {
        return postoVacinacaoId;
    }

    @Override
    public String getDataFormatada() {
        return data.toString();
    }

    @Override
    public LocalDate getData() {
        return data;
    }
}
