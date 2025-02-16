package com.fiap.hackathon.agendamento.infra.client.mappers.response;

import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoCompleto;
import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoCompletoDomain;
import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoVacinacao;
import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoVacinacaoDomain;
import com.fiap.hackathon.agendamento.infra.client.response.usuario.historico.HistoricoVacinaResponse;
import com.fiap.hackathon.agendamento.infra.client.response.usuario.historico.HistoricoVacinacaoResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.apache.commons.collections.CollectionUtils.isNotEmpty;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface HistoricoVacinacaoResponseMapper {

    default HistoricoCompleto toDomain(final HistoricoVacinacaoResponse response) {
        return nonNull(response) && isNotEmpty(response.historico())
                ? HistoricoCompletoDomain.of(toDomains(response.historico()))
                : HistoricoCompletoDomain.empty();
    }

    List<HistoricoVacinacao> toDomains(List<HistoricoVacinaResponse> responses);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "vacinaId", source = "vacina")
    @Mapping(target = "postoVacinacaoId", source = "local")
    @Mapping(target = "data", source = "data")
    HistoricoVacinacaoDomain toHistoricoVacinacaoDomain(HistoricoVacinaResponse response);
}
