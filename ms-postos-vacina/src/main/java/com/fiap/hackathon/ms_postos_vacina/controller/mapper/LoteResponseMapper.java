package com.fiap.hackathon.ms_postos_vacina.controller.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.response.LoteResponse;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.LoteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoteResponseMapper {
    LoteResponse toLoteResponse(LoteEntity lote);
}
