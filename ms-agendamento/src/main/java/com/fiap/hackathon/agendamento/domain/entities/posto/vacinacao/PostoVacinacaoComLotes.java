package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.lote.Lote;

import java.util.List;
import java.util.Optional;

public interface PostoVacinacaoComLotes extends PostoVacinacao {
    List<Lote> getLotes();

    Optional<Lote> getLote(Long vacinaId);

    void putLote(Lote lote);

    boolean isContainsStock(Long vacinaId);

    boolean isNoContainsStock(Long vacinaId);
}
