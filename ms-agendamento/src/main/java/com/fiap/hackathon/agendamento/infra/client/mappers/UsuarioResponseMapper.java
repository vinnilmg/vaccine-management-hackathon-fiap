package com.fiap.hackathon.agendamento.infra.client.mappers;

import com.fiap.hackathon.agendamento.domain.entities.usuario.UsuarioDomain;
import com.fiap.hackathon.agendamento.infra.client.response.UsuarioResponse;
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
public interface UsuarioResponseMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "numeroCarteira", source = "numeroCarteira")
    UsuarioDomain toDomain(UsuarioResponse usuarioResponse);
}
