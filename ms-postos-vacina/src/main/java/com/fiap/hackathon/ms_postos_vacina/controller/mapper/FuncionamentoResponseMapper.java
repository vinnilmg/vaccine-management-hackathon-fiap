package com.fiap.hackathon.ms_postos_vacina.controller.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.response.FuncionamentoResponse;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.FuncionamentoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuncionamentoResponseMapper {
    FuncionamentoResponse toFuncionamentoResponse(FuncionamentoEntity funcionamento);
}
