package com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.PostoVacinacao;

import java.util.Optional;

@FunctionalInterface
public interface FindPostoVacinacaoByIdGateway {
    Optional<PostoVacinacao> find(Long postoVacinacaoId, Long vacinaId);
}
