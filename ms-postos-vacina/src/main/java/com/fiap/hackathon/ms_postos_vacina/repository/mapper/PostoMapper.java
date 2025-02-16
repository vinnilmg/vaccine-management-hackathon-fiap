package com.fiap.hackathon.ms_postos_vacina.repository.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoRequest;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.Endereco;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.Posto;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.StatusPostoEnum;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.TipoLocalEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", imports = {Endereco.class, StatusPostoEnum.class})
public interface PostoMapper {
    @Mapping(target = "status", expression = "java(StatusPostoEnum.ATIVO)")
    @Mapping(target = "tipoLocal", source = "tipoLocal", qualifiedByName = "mapTipoLocal")
    Posto toPosto(PostoRequest request);

    @Named("mapTipoLocal")
    default TipoLocalEnum mapTipoLocal(String tipoLocal) {
        return TipoLocalEnum.UBS;
    }
}
