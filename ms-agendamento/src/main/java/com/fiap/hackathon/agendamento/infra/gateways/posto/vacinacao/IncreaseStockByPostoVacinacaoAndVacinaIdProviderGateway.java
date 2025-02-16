package com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao;

import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.IncreaseStockByPostoVacinacaoAndVacinaIdGateway;
import com.fiap.hackathon.agendamento.infra.client.PostoVacinacaoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IncreaseStockByPostoVacinacaoAndVacinaIdProviderGateway implements IncreaseStockByPostoVacinacaoAndVacinaIdGateway {
    private final PostoVacinacaoClient postoVacinacaoClient;

    public IncreaseStockByPostoVacinacaoAndVacinaIdProviderGateway(PostoVacinacaoClient postoVacinacaoClient) {
        this.postoVacinacaoClient = postoVacinacaoClient;
    }

    @Override
    public void increase(final Long postoVacinacaoId, final Long vacinaId) {
        log.info("Aumentando estoque no microsserviço...");
        postoVacinacaoClient.increaseStock(postoVacinacaoId, vacinaId);
    }
}
