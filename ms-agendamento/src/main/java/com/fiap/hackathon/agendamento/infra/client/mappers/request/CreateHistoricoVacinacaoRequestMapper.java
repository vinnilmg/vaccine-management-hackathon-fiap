package com.fiap.hackathon.agendamento.infra.client.mappers.request;

import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.infra.client.request.CreateHistoricoVacinacaoRequest;
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
public interface CreateHistoricoVacinacaoRequestMapper {

    @Mapping(target = "usuarioId", source = "usuarioId")
    @Mapping(target = "vacinaId", source = "vacinaId")
    @Mapping(target = "localId", source = "postoVacinacaoId")
    @Mapping(target = "dataAplicacao", source = "data")
    CreateHistoricoVacinacaoRequest toRequest(Agendamento agendamento);
}
