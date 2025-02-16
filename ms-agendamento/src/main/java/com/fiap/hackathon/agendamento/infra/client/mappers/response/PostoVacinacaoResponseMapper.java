package com.fiap.hackathon.agendamento.infra.client.mappers.response;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.PostoVacinacaoDomain;
import com.fiap.hackathon.agendamento.infra.client.response.posto.vacinacao.PostoVacinacaoResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {VacinaResponseMapper.class, FuncionamentoPostoResponseMapper.class}
)
public interface PostoVacinacaoResponseMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "funcionamento", source = "funcionamento")
    PostoVacinacaoDomain toDomain(PostoVacinacaoResponse postoVacinacaoResponse);
}
