package com.br.fiap.application.service;

import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.dto.response.UsuarioResponse;
import com.br.fiap.core.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAll();

    UsuarioResponse getById(Long id);

    public List<MovimentacaoVacinaResponse> getAllMovimentacoesVacinByVacinaIdAndUserId(Long userId,Long vacinaId);

    Usuario create(UsuarioRequest usuarioModel);

    Usuario update(Long id, UsuarioRequest usuarioModel);

    void validateUserTitularAge(Long id);

    void delete(Long id);
}
