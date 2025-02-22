package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.lote;

import java.time.LocalDate;

public interface Lote {
    Long getId();

    String getNumero();

    Long getPostoVacinacaoId();

    Long getVacinaId();

    LocalDate getValidade();

    Integer getEstoque();

    boolean containsEstoque();

    boolean isExpired(LocalDate dataAgendamento);

    boolean isNoExpired(LocalDate dataAgendamento);
}
