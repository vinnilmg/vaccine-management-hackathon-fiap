package com.fiap.hackathon.agendamento.infra.client.mappers;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.FuncionamentoDomain;
import com.fiap.hackathon.agendamento.infra.client.response.FuncionamentoPostoResponse;
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
public interface FuncionamentoPostoResponseMapper {

    @Mapping(target = "diaSemana", source = "dia")
    @Mapping(target = "horarioInicio", source = "horario.inicio")
    @Mapping(target = "horarioFim", source = "horario.termino")
    FuncionamentoDomain toDomain(FuncionamentoPostoResponse funcionamentoPostoResponse);
}
