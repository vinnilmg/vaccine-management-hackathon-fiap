package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.lote.Lote;

import java.util.List;

public interface PostoVacinacaoComLotes extends PostoVacinacao {
    List<Lote> getLotes();

    void putLote(Lote lote);

    boolean isContainsStock(Long vacinaId);

    boolean isNoContainsStock(Long vacinaId);
}
