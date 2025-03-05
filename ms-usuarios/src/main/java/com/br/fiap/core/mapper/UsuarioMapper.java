package com.br.fiap.core.mapper;

import com.br.fiap.application.dto.response.UsuarioResponse;
import com.br.fiap.core.entity.UsuarioData;
import com.br.fiap.core.enums.TipoPacienteEnum;
import com.br.fiap.core.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UsuarioMapper {

    final ModelMapper modelMapper;

    public Usuario toModel(UsuarioData usuarioData) {
        TypeMap<UsuarioData, Usuario> typeMap = modelMapper.getTypeMap(UsuarioData.class, Usuario.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(UsuarioData.class, Usuario.class);
        }
        configureMappings();
        return typeMap.map(usuarioData);
    }

    private void configureMappings() {
        TypeMap<Usuario, UsuarioResponse> typeMap = modelMapper.getTypeMap(Usuario.class, UsuarioResponse.class);

        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(Usuario.class, UsuarioResponse.class);
        }

        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getDependenteDe() != null ? src.getDependenteDe().getId() : null,
                    UsuarioResponse::setDependenteDeId);

            mapper.map(src -> src.getDependentesList() != null ?
                            src.getDependentesList().stream().map(Usuario::getId).collect(Collectors.toList())
                            : null,
                    UsuarioResponse::setDependentesListid);
        });
    }

    public UsuarioData toData(Usuario usuario) {
        TypeMap<Usuario, UsuarioData> typeMap = modelMapper.getTypeMap(Usuario.class, UsuarioData.class);
        if (typeMap == null) {
            typeMap = modelMapper.createTypeMap(Usuario.class, UsuarioData.class);
        }
        return typeMap.map(usuario);
    }

    public UsuarioResponse toResponse(Usuario usuario) {
        if (usuario.getTipo().equals(TipoPacienteEnum.TITULAR)) {
            return UsuarioResponse.builder()
                    .id(usuario.getId())
                    .nome(usuario.getNome())
                    .cpf(usuario.getCpf())
                    .email(usuario.getEmail())
                    .telefone(usuario.getTelefone())
                    .enderecoId(usuario.getEndereco().getId())
                    .dataNascimento(usuario.getDataNascimento())
                    .numeroCarteirinhaSUS(usuario.getNumeroCarteirinhaSUS())
                    .tipo(usuario.getTipo())
                    .dependentesListid(Objects.nonNull(usuario.getDependentesList()) ? usuario.getDependentesList().stream().map(Usuario::getId).toList() : null)
                    .build();
        }

        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .cpf(usuario.getCpf())
                .email(usuario.getEmail())
                .telefone(usuario.getTelefone())
                .enderecoId(usuario.getEndereco().getId())
                .dataNascimento(usuario.getDataNascimento())
                .numeroCarteirinhaSUS(usuario.getNumeroCarteirinhaSUS())
                .tipo(usuario.getTipo())
                .dependenteDeId(usuario.getDependenteDe() != null ? usuario.getDependenteDe().getId() : null)
                .build();
    }

    public UsuarioResponse toResponse(UsuarioData usuario) {
        if (usuario.getTipo().equals(TipoPacienteEnum.TITULAR)) {
            return UsuarioResponse.builder()
                    .id(usuario.getId())
                    .nome(usuario.getNome())
                    .cpf(usuario.getCpf())
                    .email(usuario.getEmail())
                    .telefone(usuario.getTelefone())
                    .enderecoId(usuario.getEndereco().getId())
                    .dataNascimento(usuario.getDataNascimento())
                    .numeroCarteirinhaSUS(usuario.getNumeroCarteirinhaSUS())
                    .tipo(usuario.getTipo())
                    .dependentesListid(Objects.nonNull(usuario.getDependentesList()) ? usuario.getDependentesList().stream().map(UsuarioData::getId).toList() : null)
                    .build();
        }

        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .cpf(usuario.getCpf())
                .email(usuario.getEmail())
                .telefone(usuario.getTelefone())
                .enderecoId(usuario.getEndereco().getId())
                .dataNascimento(usuario.getDataNascimento())
                .numeroCarteirinhaSUS(usuario.getNumeroCarteirinhaSUS())
                .tipo(usuario.getTipo())
                .dependenteDeId(usuario.getDependenteDe() != null ? usuario.getDependenteDe().getId() : null)
                .build();
    }
}
