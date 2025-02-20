package com.fiap.hackathon.agendamento.infra.controllers.mappers;

import com.fiap.hackathon.agendamento.domain.entities.agendamento.Agendamento;
import com.fiap.hackathon.agendamento.domain.entities.agendamento.AgendamentoDomain;
import com.fiap.hackathon.agendamento.infra.controllers.request.AgendamentoRequest;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AgendamentoRequestMapper {

    default Agendamento toDomain(final AgendamentoRequest request) {
        return AgendamentoDomain.ofNovoAgendamento(
                request.usuarioId(),
                request.postoVacinacaoId(),
                request.vacinaId(),
                request.dataHoraAgendamento()
        );
    }
}
