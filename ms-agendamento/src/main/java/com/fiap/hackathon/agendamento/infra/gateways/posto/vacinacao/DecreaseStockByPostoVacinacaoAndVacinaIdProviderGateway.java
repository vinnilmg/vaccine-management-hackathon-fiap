package com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao;

import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.DecreaseStockByPostoVacinacaoAndVacinaIdGateway;
import com.fiap.hackathon.agendamento.infra.client.PostoVacinacaoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DecreaseStockByPostoVacinacaoAndVacinaIdProviderGateway implements DecreaseStockByPostoVacinacaoAndVacinaIdGateway {
    private final PostoVacinacaoClient postoVacinacaoClient;

    public DecreaseStockByPostoVacinacaoAndVacinaIdProviderGateway(PostoVacinacaoClient postoVacinacaoClient) {
        this.postoVacinacaoClient = postoVacinacaoClient;
    }

    @Override
    public void decrease(final Long postoVacinacaoId, final Long vacinaId) {
        log.info("Diminuindo estoque no microsserviço...");
        postoVacinacaoClient.decreaseStock(postoVacinacaoId, vacinaId);
    }
}
