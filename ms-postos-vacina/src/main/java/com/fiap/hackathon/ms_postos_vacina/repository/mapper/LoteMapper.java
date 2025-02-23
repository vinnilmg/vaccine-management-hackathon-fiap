package com.fiap.hackathon.ms_postos_vacina.repository.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.request.LoteRequest;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.LoteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoteMapper {
    LoteEntity toLote(LoteRequest request);
}
