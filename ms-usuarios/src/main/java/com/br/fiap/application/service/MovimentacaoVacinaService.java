package com.br.fiap.application.service;

import com.br.fiap.application.dto.request.MovimentacaoVacinaRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.core.model.MovimentacaoVacina;

import java.util.List;

public interface MovimentacaoVacinaService {

    List<MovimentacaoVacina> getAllMovimentacoes();

    MovimentacaoVacina getMovimentacaoById(Long id);

    MovimentacaoVacinaResponse create(MovimentacaoVacinaRequest movimentacaoModel);

    MovimentacaoVacinaResponse update(Long id, MovimentacaoVacinaRequest movimentacaoVacinaRequest);

    void delete(Long id);
}
