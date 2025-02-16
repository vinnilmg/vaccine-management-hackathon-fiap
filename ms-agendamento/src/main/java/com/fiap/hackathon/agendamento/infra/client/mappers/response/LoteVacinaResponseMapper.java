package com.fiap.hackathon.agendamento.infra.client.mappers.response;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.lote.LoteDomain;
import com.fiap.hackathon.agendamento.infra.client.response.posto.vacinacao.lote.LoteVacinaResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface LoteVacinaResponseMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "numero", source = "numero")
    @Mapping(target = "postoVacinacaoId", source = "postoVacinacaoId")
    @Mapping(target = "vacinaId", source = "vacinaId")
    @Mapping(target = "dataValidade", source = "validade")
    @Mapping(target = "estoque", source = "estoque")
    LoteDomain toDomain(LoteVacinaResponse response);
}
