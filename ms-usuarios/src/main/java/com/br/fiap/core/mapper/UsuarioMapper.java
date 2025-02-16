package com.br.fiap.core.mapper;

import com.br.fiap.core.entity.UsuarioData;
import com.br.fiap.core.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioMapper {

     final ModelMapper modelMapper;

    public Usuario toModel(UsuarioData usuarioData) {
        TypeMap<UsuarioData, Usuario> typeMap = modelMapper.getTypeMap(UsuarioData.class, Usuario.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(UsuarioData.class, Usuario.class);
        }
        return typeMap.map(usuarioData);
    }

    public UsuarioData toData(Usuario usuario) {
        TypeMap<Usuario, UsuarioData> typeMap = modelMapper.getTypeMap(Usuario.class, UsuarioData.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(Usuario.class, UsuarioData.class);
        }
        return typeMap.map(usuario);
    }
}
