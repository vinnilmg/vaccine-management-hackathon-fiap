package com.fiap.hackathon.agendamento.domain.entities.usuario.historico;

import java.time.LocalDate;

public interface HistoricoVacinacao {
    Long getId();

    Long getVacinaId();

    Long getPostoVacinacaoId();

    String getDataFormatada();

    LocalDate getData();
}
