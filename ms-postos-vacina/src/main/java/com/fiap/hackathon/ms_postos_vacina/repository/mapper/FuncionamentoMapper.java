package com.fiap.hackathon.ms_postos_vacina.repository.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.request.FuncionamentoRequest;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.FuncionamentoEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.DiasSemanaEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionamentoMapper {

    @Mapping(target = "posto", ignore = true)
    @Mapping(target = "diaSemana", source = "diaSemana")
    @Mapping(target = "horarioInicio", source = "horarioInicio")
    @Mapping(target = "horarioFim", source = "horarioFim")
    FuncionamentoEntity toFuncionamento(FuncionamentoRequest request);

    List<FuncionamentoEntity> toFuncionamentoList(List<FuncionamentoRequest> request);

    default DiasSemanaEnum toDiaSemanaEnum(final String diaSemana) {
        return DiasSemanaEnum.toEnum(diaSemana);
    }
}
