package com.fiap.hackathon.ms_postos_vacina.repository.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoRequest;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.PostoEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.StatusPostoEnum;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.TipoLocalEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        imports = {StatusPostoEnum.class},
        uses = {
                FuncionamentoMapper.class,
                EnderecoMapper.class
        }
)
public interface PostoMapper {

    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "status", expression = "java(StatusPostoEnum.ATIVO)")
    @Mapping(target = "tipoLocal", source = "tipoLocal")
    @Mapping(target = "funcionamento", source = "funcionamento")
    PostoEntity toPosto(PostoRequest request);

    default TipoLocalEnum toTipoLocalEnum(final String tipoLocal) {
        return TipoLocalEnum.toEnum(tipoLocal);
    }
}
