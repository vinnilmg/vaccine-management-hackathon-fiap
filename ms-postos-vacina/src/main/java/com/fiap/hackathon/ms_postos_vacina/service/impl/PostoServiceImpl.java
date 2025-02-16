package com.fiap.hackathon.ms_postos_vacina.service.impl;

import com.fiap.hackathon.ms_postos_vacina.controller.mapper.PostoResponseMapper;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoUpdateRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;
import com.fiap.hackathon.ms_postos_vacina.exception.PostoNotFoundException;
import com.fiap.hackathon.ms_postos_vacina.repository.PostoRepository;
import com.fiap.hackathon.ms_postos_vacina.repository.mapper.PostoMapper;
import com.fiap.hackathon.ms_postos_vacina.service.PostoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostoServiceImpl implements PostoService {
    @Autowired
    private PostoRepository postoRepository;
    @Autowired
    private PostoResponseMapper postoResponseMapper;
    @Autowired
    private PostoMapper postoMapper;

    @Override
    public List<PostoResponse> buscaPostos() {
        return postoRepository.findAll()
                .stream()
                .map(postoResponseMapper::toPostoResponse)
                .toList();
    }

    @Override
    public PostoResponse buscaPosto(Long id) {
        return postoRepository.findById(id)
                .map(postoResponseMapper::toPostoResponse)
                .orElseThrow(PostoNotFoundException::new);
    }

    @Override
    public List<PostoResponse> encontraPorBairro(String bairro) {
        return postoRepository.findByEnderecoBairro(bairro)
                .stream()
                .map(postoResponseMapper::toPostoResponse)
                .toList();
    }

    @Override
    public PostoResponse criaPosto(PostoRequest request) {
        final var posto = postoMapper.toPosto(request);
        postoRepository.save(posto);
        return postoResponseMapper.toPostoResponse(posto);
    }

    @Override
    public PostoResponse atualizaPosto(Long id, PostoUpdateRequest postoUpdateRequest) {
        var posto = postoRepository.findById(id)
                .orElseThrow(PostoNotFoundException::new);

        posto.setNome(postoUpdateRequest.getNome());
        posto.setFuncionamento(postoUpdateRequest.getFuncionamentoList());
        posto.setStatus(postoUpdateRequest.getStatusPosto());
        return postoResponseMapper.toPostoResponse(postoRepository.save(posto));
    }

}
