package com.br.fiap.application.service.impl;

import com.br.fiap.core.entity.EnderecoData;
import com.br.fiap.core.mapper.EnderecoMapper;
import com.br.fiap.application.dto.request.EnderecoRequest;
import com.br.fiap.application.exception.NotFoundException;
import com.br.fiap.application.service.EnderecoService;
import com.br.fiap.core.model.Endereco;
import com.br.fiap.core.repository.EnderecoDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {
    private final EnderecoDataRepository enderecoDataRepository;
    private final EnderecoMapper enderecoMapper;

    @Override
    public List<Endereco> getAll() {
        return List.of();
    }

    @Override
    public Endereco getById(Long id) {
        return enderecoDataRepository.findById(id)
                .map(enderecoMapper::toModel)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Endereço com ID %s não encontrado", id)));


    }

    @Override
    public Endereco create(EnderecoRequest enderecoRequest) {
        return enderecoMapper.toModel(enderecoDataRepository.save(EnderecoData.builder()
                .cep(enderecoRequest.cep())
                .rua(enderecoRequest.rua())
                .bairro(enderecoRequest.bairro())
                .cidade(enderecoRequest.cidade())
                .numero(enderecoRequest.numero())
                .estado(enderecoRequest.estado())
                .complemento(enderecoRequest.complemento())
                .build()));
    }

    @Override
    public Endereco update(Long id, EnderecoRequest enderecoRequest) {
        Endereco endereco = getById(id);
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
