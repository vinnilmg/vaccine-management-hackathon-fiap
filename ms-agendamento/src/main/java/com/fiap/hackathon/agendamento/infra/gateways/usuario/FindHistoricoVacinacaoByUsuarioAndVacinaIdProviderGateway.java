package com.fiap.hackathon.agendamento.infra.gateways.usuario;

import com.fiap.hackathon.agendamento.application.gateway.usuario.FindHistoricoVacinacaoByUsuarioAndVacinaIdGateway;
import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoCompleto;
import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoCompletoDomain;
import com.fiap.hackathon.agendamento.infra.client.UsuarioClient;
import com.fiap.hackathon.agendamento.infra.client.mappers.response.HistoricoVacinacaoResponseMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FindHistoricoVacinacaoByUsuarioAndVacinaIdProviderGateway implements FindHistoricoVacinacaoByUsuarioAndVacinaIdGateway {
    private final UsuarioClient usuarioClient;
    private final HistoricoVacinacaoResponseMapper historicoVacinacaoResponseMapper;

    public FindHistoricoVacinacaoByUsuarioAndVacinaIdProviderGateway(
            UsuarioClient usuarioClient,
            HistoricoVacinacaoResponseMapper historicoVacinacaoResponseMapper
    ) {
        this.usuarioClient = usuarioClient;
        this.historicoVacinacaoResponseMapper = historicoVacinacaoResponseMapper;
    }

    @Override
    public HistoricoCompleto find(final Long usuarioId, final Long vacinaId) {
        log.info("Buscando histórico de vacinação no microsserviço...");
        try {
            final var response = usuarioClient.getHistoricoVacinacaoByUsuarioAndVacinaId(usuarioId, vacinaId);
            return historicoVacinacaoResponseMapper.toDomain(response);
        } catch (FeignException e) {
            if (e.status() != HttpStatus.NOT_FOUND.value()) {
                throw e;
            }
        }
        return HistoricoCompletoDomain.empty();
    }
}
