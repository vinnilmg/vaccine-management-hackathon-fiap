package com.fiap.hackathon.agendamento.infra.client.mappers;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina.VacinaDomain;
import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina.lote.LoteDomain;
import com.fiap.hackathon.agendamento.infra.client.response.LoteVacinaResponse;
import com.fiap.hackathon.agendamento.infra.client.response.VacinaResponse;
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
public interface VacinaResponseMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "lotes", source = "lotes")
    VacinaDomain toDomain(VacinaResponse vacinaResponse);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "codigo", source = "codigo")
    @Mapping(target = "estoque", source = "estoque")
    @Mapping(target = "dataValidade", source = "validade")
    LoteDomain toLoteDomain(LoteVacinaResponse loteVacinaResponse);
}
