package com.br.fiap.application.controller.mapper;

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
}
