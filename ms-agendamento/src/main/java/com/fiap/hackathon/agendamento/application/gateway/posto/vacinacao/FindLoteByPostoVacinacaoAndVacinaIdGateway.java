package com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.lote.Lote;

import java.util.Optional;

@FunctionalInterface
public interface FindLoteByPostoVacinacaoAndVacinaIdGateway {
    Optional<Lote> find(Long postoVacinacaoId, Long vacinaId);
}
