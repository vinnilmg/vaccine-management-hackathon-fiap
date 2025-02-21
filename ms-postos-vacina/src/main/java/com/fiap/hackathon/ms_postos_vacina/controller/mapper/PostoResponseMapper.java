package com.fiap.hackathon.ms_postos_vacina.controller.mapper;

import com.fiap.hackathon.ms_postos_vacina.controller.response.EnderecoResponse;
import com.fiap.hackathon.ms_postos_vacina.controller.response.FuncionamentoResponse;
import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.EnderecoEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.FuncionamentoEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.PostoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PostoResponseMapper {
    @Mapping(target = "endereco", source = "endereco", qualifiedByName = "mapEndereco")
    @Mapping(target = "funcionamento", source = "funcionamento", qualifiedByName = "mapFuncionamento")
    PostoResponse toPostoResponse(PostoEntity posto);

    @Named("mapEndereco")
    default EnderecoResponse mapEndereco(EnderecoEntity endereco) {
        return Mappers.getMapper(EnderecoResponseMapper.class).toEnderecoResponse(endereco);
    }

    @Named("mapFuncionamento")
    default FuncionamentoResponse mapFuncionamento(FuncionamentoEntity funcionamento) {
        return Mappers.getMapper(FuncionamentoResponseMapper.class).toFuncionamentoResponse(funcionamento);
    }

}
