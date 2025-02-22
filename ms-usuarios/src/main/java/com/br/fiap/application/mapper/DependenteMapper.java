package com.br.fiap.application.mapper;
import com.br.fiap.application.dto.response.DependenteResponse;
import com.br.fiap.core.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DependenteMapper {

    final ModelMapper modelMapper;

    public DependenteResponse toResponse(Usuario usuario) {
        TypeMap<Usuario, DependenteResponse> typeMap = modelMapper.getTypeMap(Usuario.class, DependenteResponse.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(Usuario.class, DependenteResponse.class);
        }
        return typeMap.map(usuario);
    }

}
