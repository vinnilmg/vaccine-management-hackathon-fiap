package com.fiap.hackathon.agendamento.infra.gateways.vacina;

import com.fiap.hackathon.agendamento.application.gateway.vacina.FindVacinaByIdGateway;
import com.fiap.hackathon.agendamento.domain.entities.vacina.Vacina;
import com.fiap.hackathon.agendamento.infra.client.VacinaClient;
import com.fiap.hackathon.agendamento.infra.client.mappers.response.VacinaResponseMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class FindVacinaByIdProviderGateway implements FindVacinaByIdGateway {
    private final VacinaClient vacinaClient;
    private final VacinaResponseMapper vacinaResponseMapper;

    public FindVacinaByIdProviderGateway(VacinaClient vacinaClient, VacinaResponseMapper vacinaResponseMapper) {
        this.vacinaClient = vacinaClient;
        this.vacinaResponseMapper = vacinaResponseMapper;
    }

    @Override
    public Optional<Vacina> find(final Long id) {
        log.info("Buscando vacina no microsserviço...");
        try {
            return Optional.ofNullable(vacinaClient.getVacinaById(id))
                    .map(vacinaResponseMapper::toDomain);
        } catch (FeignException e) {
            if (e.status() != HttpStatus.NOT_FOUND.value()) {
                throw e;
            }
        }
        return Optional.empty();
    }
}
