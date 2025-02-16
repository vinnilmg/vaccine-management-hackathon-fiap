package com.fiap.hackathon.agendamento.domain.entities.usuario.historico;

import java.util.List;

public interface HistoricoCompleto {
    List<HistoricoVacinacao> getHistorico();

    boolean isExists();

    boolean isNotExists();


}
