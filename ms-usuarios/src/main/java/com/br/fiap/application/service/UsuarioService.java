package com.br.fiap.application.service;

import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.core.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAll();

    Usuario getById(Long id);

    Usuario create(UsuarioRequest usuarioModel);

    Usuario update(Long id, UsuarioRequest usuarioModel);

    void validateUserTitularAge(Long id);

    void delete(Long id);
}
