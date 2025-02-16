package com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao;

@FunctionalInterface
public interface IncreaseStockByPostoVacinacaoAndVacinaIdGateway {
    void increase(Long postoVacinacaoId, Long vacinaId);
}
