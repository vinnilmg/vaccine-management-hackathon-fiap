package com.br.fiap.application.service;

import com.br.fiap.application.dto.request.EnderecoRequest;
import com.br.fiap.core.model.Endereco;

import java.util.List;

public interface EnderecoService {
    List<Endereco> getAll();
    Endereco getById(Long id);
    Endereco create(EnderecoRequest enderecoRequest);
    Endereco update(Long id, EnderecoRequest enderecoRequest);
    void delete(Long id);
}
