package com.fiap.hackathon.agendamento.infra.persistence.mappers;

import com.fiap.hackathon.agendamento.domain.entities.Agendamento;
import com.fiap.hackathon.agendamento.domain.entities.AgendamentoDomain;
import com.fiap.hackathon.agendamento.infra.persistence.entities.AgendamentoEntity;
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
public interface AgendamentoEntityMapper {

    List<Agendamento> toAgendamentosDomain(List<AgendamentoEntity> agendamentos);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "usuarioId", source = "usuarioId")
    @Mapping(target = "postoVacinacaoId", source = "postoVacinacaoId")
    @Mapping(target = "vacinaId", source = "vacinaId")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "dataHoraAgendamento", source = "dataHoraAgendamento")
    AgendamentoDomain toAgendamentoDomain(AgendamentoEntity agendamento);
}
