package com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao;

import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.FindPostoVacinacaoByIdGateway;
import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.PostoVacinacaoComLotes;
import com.fiap.hackathon.agendamento.infra.client.PostoVacinacaoClient;
import com.fiap.hackathon.agendamento.infra.client.mappers.response.PostoVacinacaoResponseMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class FindPostoVacinacaoByIdProviderGateway implements FindPostoVacinacaoByIdGateway {
    private final PostoVacinacaoClient client;
    private final PostoVacinacaoResponseMapper postoVacinacaoResponseMapper;

    public FindPostoVacinacaoByIdProviderGateway(
            PostoVacinacaoClient client,
            PostoVacinacaoResponseMapper postoVacinacaoResponseMapper
    ) {
        this.client = client;
        this.postoVacinacaoResponseMapper = postoVacinacaoResponseMapper;
    }

    @Override
    public Optional<PostoVacinacaoComLotes> find(final Long id) {
        log.info("Buscando posto de vacinação no microsserviço...");
        try {
            return Optional.ofNullable(client.getPostoVacinacaoById(id))
                    .map(postoVacinacaoResponseMapper::toDomain);
        } catch (FeignException e) {
            if (e.status() != HttpStatus.NOT_FOUND.value()) {
                throw e;
            }
        }
        return Optional.empty();
    }
}
