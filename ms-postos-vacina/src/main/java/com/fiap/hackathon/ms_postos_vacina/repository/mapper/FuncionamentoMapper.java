package com.fiap.hackathon.ms_postos_vacina.repository.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.request.FuncionamentoRequest;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.FuncionamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FuncionamentoMapper {
    @Mapping(target = "posto", ignore = true)
    FuncionamentoEntity toFuncionamento(FuncionamentoRequest request);

    List<FuncionamentoEntity> toFuncionamentoList(List<FuncionamentoRequest> funcionamentoRequestList);
}
