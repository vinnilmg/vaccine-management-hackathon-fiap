package com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao;

import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.FindPostoVacinacaoByIdGateway;
import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.PostoVacinacao;
import com.fiap.hackathon.agendamento.infra.client.PostoVacinacaoClient;
import com.fiap.hackathon.agendamento.infra.client.mappers.PostoVacinacaoResponseMapper;
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
    public Optional<PostoVacinacao> find(final Long postoVacinacaoId, final Long vacinaId) {
        log.info("Buscando posto de vacinação no microsserviço...");
        try {
            return Optional.ofNullable(client.getPostoAndVacinaById(postoVacinacaoId, vacinaId))
                    .map(postoVacinacaoResponseMapper::toDomain);
        } catch (FeignException e) {
            if (e.status() != HttpStatus.NOT_FOUND.value()) {
                throw e;
            }
        }
        return Optional.empty();
    }
}
