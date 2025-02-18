package com.br.fiap.application.service;

import com.br.fiap.application.dto.request.MovimentacaoVacinaRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;

import java.util.List;

public interface MovimentacaoVacinaService {

    List<MovimentacaoVacinaResponse> getAllMovimentacoes();

    MovimentacaoVacinaResponse getMovimentacaoById(Long id);

    List<MovimentacaoVacinaResponse> getAlltMovimentacaoByUsuarioId(Long idUsuario);

    MovimentacaoVacinaResponse create(MovimentacaoVacinaRequest movimentacaoModel);

    MovimentacaoVacinaResponse update(Long id, MovimentacaoVacinaRequest movimentacaoVacinaRequest);

    void delete(Long id);
}
