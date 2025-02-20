package com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.PostoVacinacaoComLotes;

import java.util.Optional;

@FunctionalInterface
public interface FindPostoVacinacaoByIdGateway {
    Optional<PostoVacinacaoComLotes> find(Long id);
}
