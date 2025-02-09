package com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao;

import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.FindPostoVacinacaoByIdGateway;
import com.fiap.hackathon.agendamento.infra.client.PostoVacinacaoClient;
import com.fiap.hackathon.agendamento.infra.client.response.PostoVacinacaoResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class FindPostoVacinacaoByIdProviderGateway implements FindPostoVacinacaoByIdGateway {
    private final PostoVacinacaoClient client;

    public FindPostoVacinacaoByIdProviderGateway(PostoVacinacaoClient client) {
        this.client = client;
    }

    @Override
    public Optional<PostoVacinacaoResponse> find(final Long postoVacinacaoId) {
        log.info("Buscando posto de vacinação no microsserviço...");
        try {
            return Optional.ofNullable(client.getPostoVacinacaoById(postoVacinacaoId));
        } catch (FeignException e) {
            if (e.status() != HttpStatus.NOT_FOUND.value()) {
                throw e;
            }
        }
        return Optional.empty();
    }
}
