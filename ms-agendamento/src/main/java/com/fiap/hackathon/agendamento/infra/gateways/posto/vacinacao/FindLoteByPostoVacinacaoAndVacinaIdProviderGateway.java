package com.fiap.hackathon.agendamento.infra.gateways.posto.vacinacao;

import com.fiap.hackathon.agendamento.application.gateway.posto.vacinacao.FindLoteByPostoVacinacaoAndVacinaIdGateway;
import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.lote.Lote;
import com.fiap.hackathon.agendamento.infra.client.PostoVacinacaoClient;
import com.fiap.hackathon.agendamento.infra.client.mappers.response.LoteVacinaResponseMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class FindLoteByPostoVacinacaoAndVacinaIdProviderGateway implements FindLoteByPostoVacinacaoAndVacinaIdGateway {
    private final PostoVacinacaoClient postoVacinacaoClient;
    private final LoteVacinaResponseMapper loteVacinaResponseMapper;

    public FindLoteByPostoVacinacaoAndVacinaIdProviderGateway(
            PostoVacinacaoClient postoVacinacaoClient,
            LoteVacinaResponseMapper loteVacinaResponseMapper
    ) {
        this.postoVacinacaoClient = postoVacinacaoClient;
        this.loteVacinaResponseMapper = loteVacinaResponseMapper;
    }

    @Override
    public Optional<Lote> find(final Long postoVacinacaoId, final Long vacinaId) {
        log.info("Buscando lote de vacina no microsserviço...");
        try {
            return Optional.ofNullable(postoVacinacaoClient.getLoteByPostoVacinacaoIdAndVacinaId(postoVacinacaoId, vacinaId))
                    .map(loteVacinaResponseMapper::toDomain);
        } catch (FeignException e) {
            if (e.status() != HttpStatus.NOT_FOUND.value()) {
                throw e;
            }
        }
        return Optional.empty();
    }
}
