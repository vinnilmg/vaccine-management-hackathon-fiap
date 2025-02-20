package com.fiap.hackathon.agendamento.domain.entities.usuario.historico;

import java.util.List;

import static java.util.Objects.isNull;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

public class HistoricoCompletoDomain implements HistoricoCompleto {
    private final List<HistoricoVacinacao> historico;

    public static HistoricoCompleto of(final List<HistoricoVacinacao> historico) {
        return new HistoricoCompletoDomain(historico);
    }

    public static HistoricoCompleto empty() {
        return new HistoricoCompletoDomain();
    }

    public HistoricoCompletoDomain(final List<HistoricoVacinacao> historico) {
        this.historico = isNull(historico) ? List.of() : historico;
    }

    private HistoricoCompletoDomain() {
        this.historico = List.of();
    }

    @Override
    public List<HistoricoVacinacao> getHistorico() {
        return historico;
    }

    @Override
    public boolean isExists() {
        return isNotEmpty(historico);
    }

    @Override
    public boolean isNotExists() {
        return !isExists();
    }
}
