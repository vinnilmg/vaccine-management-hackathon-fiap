package com.br.fiap.application.service.impl;

import com.br.fiap.application.dto.request.EnderecoRequest;
import com.br.fiap.application.exception.NotFoundException;
import com.br.fiap.application.service.EnderecoService;
import com.br.fiap.core.entity.EnderecoData;
import com.br.fiap.core.mapper.EnderecoMapper;
import com.br.fiap.core.model.Endereco;
import com.br.fiap.core.repository.EnderecoDataRepository;
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
                .cep(enderecoRequest.getCep())
                .rua(enderecoRequest.getRua())
                .bairro(enderecoRequest.getBairro())
                .cidade(enderecoRequest.getCidade())
                .numero(enderecoRequest.getNumero())
                .estado(enderecoRequest.getEstado())
                .complemento(enderecoRequest.getComplemento())
                .build()));
    }

    @Override
    public Endereco update(Long id, EnderecoRequest enderecoRequest) {
        Endereco endereco = getById(id);
        return null;
    }

    @Override
    public void delete(Long id) {
        enderecoDataRepository.deleteById(id);
    }
}
