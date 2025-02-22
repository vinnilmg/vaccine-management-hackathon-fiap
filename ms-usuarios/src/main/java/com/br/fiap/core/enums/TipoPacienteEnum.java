package com.br.fiap.core.enums;

import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.application.exception.ValidationException;
import com.br.fiap.core.model.Endereco;
import com.br.fiap.core.model.Usuario;

import java.util.Optional;

public enum TipoPacienteEnum {

    TITULAR {
        @Override
        public Usuario createModel(Endereco endereco, Optional<Usuario> titular, UsuarioRequest usuarioRequest) {
            return Usuario.builder()
                    .cpf(usuarioRequest.getCpf())
                    .nome(usuarioRequest.getNome())
                    .telefone(usuarioRequest.getTelefone())
                    .email(usuarioRequest.getEmail())
                    .dataNascimento(usuarioRequest.getDataNascimento())
                    .tipo(usuarioRequest.getTipo())
                    .numeroCarteirinhaSUS(usuarioRequest.getNumeroCarteirinhaSUS())
                    .endereco(endereco)
                    .build();
        }
    },DEPENDENTE {
        @Override
        public Usuario createModel(Endereco endereco, Optional<Usuario> titular, UsuarioRequest usuarioRequest) {
            Usuario titularToSave = titular.orElseThrow(() -> new ValidationException("createModel", "Titular não está presente"));

            return Usuario.builder()
                    .cpf(usuarioRequest.getCpf())
                    .nome(usuarioRequest.getNome())
                    .telefone(usuarioRequest.getTelefone())
                    .email(usuarioRequest.getEmail())
                    .dataNascimento(usuarioRequest.getDataNascimento())
                    .tipo(usuarioRequest.getTipo())
                    .numeroCarteirinhaSUS(usuarioRequest.getNumeroCarteirinhaSUS())
                    .endereco(endereco)
                    .dependenteDe(titularToSave)
                    .build();
        }
    };


    public abstract Usuario createModel(Endereco endereco, Optional<Usuario> titular, UsuarioRequest usuarioRequest);
}
