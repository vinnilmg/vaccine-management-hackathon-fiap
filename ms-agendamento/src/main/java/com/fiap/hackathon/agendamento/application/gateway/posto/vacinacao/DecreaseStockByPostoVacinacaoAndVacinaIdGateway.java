package com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao;

@FunctionalInterface
public interface DecreaseStockByPostoVacinacaoAndVacinaIdGateway {
    void decrease(Long postoVacinacaoId, Long vacinaId);
}
