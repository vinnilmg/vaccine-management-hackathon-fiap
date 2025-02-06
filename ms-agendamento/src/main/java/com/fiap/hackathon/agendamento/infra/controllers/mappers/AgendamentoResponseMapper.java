package com.fiap.hackathon.agendamento.infra.controllers.mappers;

import com.fiap.hackathon.agendamento.domain.entities.Agendamento;
import com.fiap.hackathon.agendamento.infra.controllers.response.AgendamentoResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AgendamentoResponseMapper {

    List<AgendamentoResponse> toResponses(List<Agendamento> agendamentos);

    @Mapping(target = "agendamentoId", source = "id")
    @Mapping(target = "usuarioId", source = "usuarioId")
    @Mapping(target = "postoVacinacaoId", source = "postoVacinacaoId")
    @Mapping(target = "vacinaId", source = "vacinaId")
    @Mapping(target = "data", source = "data")
    @Mapping(target = "hora", source = "hora")
    AgendamentoResponse toResponse(Agendamento agendamento);
}
