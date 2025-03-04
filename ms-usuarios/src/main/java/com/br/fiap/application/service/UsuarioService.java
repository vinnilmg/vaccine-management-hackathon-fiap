package com.br.fiap.application.service;

import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.application.dto.response.DependenteResponse;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.dto.response.UsuarioResponse;
import com.br.fiap.core.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponse> getAll();

    UsuarioResponse getById(Long id);

    Usuario findById(Long id);

    List<MovimentacaoVacinaResponse> getAllMovimentacoesVacinByVacinaIdAndUserId(Long userId,Long vacinaId);

    List<DependenteResponse> getAllDependentesByUserId(Long userId);

    UsuarioResponse create(UsuarioRequest usuarioModel);

    UsuarioResponse update(Long id, UsuarioRequest usuarioModel);

    void validateUserTitularAge(Long id,UsuarioRequest usuarioRequest);

    void delete(Long id);
}
