package com.fiap.hackathon.ms_postos_vacina.controller.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.response.EnderecoResponse;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.EnderecoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoResponseMapper {
    EnderecoResponse toEnderecoResponse(EnderecoEntity endereco);
}
