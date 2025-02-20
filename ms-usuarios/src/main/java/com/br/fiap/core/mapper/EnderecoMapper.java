package com.br.fiap.core.mapper;
import com.br.fiap.core.entity.EnderecoData;
import com.br.fiap.core.model.Endereco;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnderecoMapper {

     final ModelMapper modelMapper;

    public Endereco toModel(EnderecoData enderecoData) {
        TypeMap<EnderecoData, Endereco> typeMap = modelMapper.getTypeMap(EnderecoData.class, Endereco.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(EnderecoData.class, Endereco.class);
        }
        return typeMap.map(enderecoData);
    }

    public EnderecoData toData(Endereco endereco) {
        TypeMap<Endereco, EnderecoData> typeMap = modelMapper.getTypeMap(Endereco.class, EnderecoData.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(Endereco.class, EnderecoData.class);
        }
        return typeMap.map(endereco);
    }

}
