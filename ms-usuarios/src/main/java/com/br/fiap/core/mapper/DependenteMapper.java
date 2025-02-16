package com.br.fiap.core.mapper;

import com.br.fiap.core.entity.DependenteData;
import com.br.fiap.core.model.Dependente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DependenteMapper {

    final ModelMapper modelMapper;

    public Dependente toModel(DependenteData dependenteData) {
        TypeMap<DependenteData, Dependente> typeMap = modelMapper.getTypeMap(DependenteData.class, Dependente.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(DependenteData.class, Dependente.class);
        }
        return typeMap.map(dependenteData);
    }

    public DependenteData toData(Dependente dependente) {
        TypeMap<Dependente, DependenteData> typeMap = modelMapper.getTypeMap(Dependente.class, DependenteData.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(Dependente.class, DependenteData.class);
        }
        return typeMap.map(dependente);
    }
}
