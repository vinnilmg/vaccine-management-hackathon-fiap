package com.br.fiap.core.mapper;

import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.core.entity.MovimentacaoVacinaData;
import com.br.fiap.core.model.MovimentacaoVacina;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MovimentacaoVacinaMapper {

     final ModelMapper modelMapper;

    public MovimentacaoVacina toModel(MovimentacaoVacinaData historicoVacinalData) {
        TypeMap<MovimentacaoVacinaData, MovimentacaoVacina> typeMap = modelMapper.getTypeMap(MovimentacaoVacinaData.class, MovimentacaoVacina.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(MovimentacaoVacinaData.class, MovimentacaoVacina.class);
        }
        return typeMap.map(historicoVacinalData);
    }

    public MovimentacaoVacinaData toData(MovimentacaoVacina historicoVacinal) {
        TypeMap<MovimentacaoVacina, MovimentacaoVacinaData> typeMap = modelMapper.getTypeMap(MovimentacaoVacina.class, MovimentacaoVacinaData.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(MovimentacaoVacina.class, MovimentacaoVacinaData.class);
        }
        return typeMap.map(historicoVacinal);
    }

    public MovimentacaoVacinaResponse toResponse(MovimentacaoVacina historicoVacinal) {
        TypeMap<MovimentacaoVacina, MovimentacaoVacinaResponse> typeMap = modelMapper.getTypeMap(MovimentacaoVacina.class, MovimentacaoVacinaResponse.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(MovimentacaoVacina.class, MovimentacaoVacinaResponse.class);
        }
        return typeMap.map(historicoVacinal);
    }

    public MovimentacaoVacinaResponse toResponse(MovimentacaoVacinaData historicoVacinal) {
        TypeMap<MovimentacaoVacinaData, MovimentacaoVacinaResponse> typeMap = modelMapper.getTypeMap(MovimentacaoVacinaData.class, MovimentacaoVacinaResponse.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(MovimentacaoVacinaData.class, MovimentacaoVacinaResponse.class);
        }
        return typeMap.map(historicoVacinal);
    }
}
