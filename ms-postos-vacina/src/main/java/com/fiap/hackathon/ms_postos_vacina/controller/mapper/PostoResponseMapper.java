package com.fiap.hackathon.ms_postos_vacina.controller.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.Posto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostoResponseMapper {
    PostoResponse toPostoResponse(Posto posto);
}
