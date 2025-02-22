package com.fiap.hackathon.ms_postos_vacina.repository.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.request.EnderecoRequest;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.EnderecoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    EnderecoEntity toEndereco(EnderecoRequest request);
}
