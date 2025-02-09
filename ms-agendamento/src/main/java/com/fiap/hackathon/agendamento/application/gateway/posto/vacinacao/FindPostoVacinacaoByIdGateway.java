package com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao;

import com.fiap.hackathon.agendamento.infra.client.response.PostoVacinacaoResponse;

import java.util.Optional;

@FunctionalInterface
public interface FindPostoVacinacaoByIdGateway {
    Optional<PostoVacinacaoResponse> find(Long postoVacinacaoId);
}
