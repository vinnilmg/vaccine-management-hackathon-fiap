package com.fiap.hackathon.ms_postos_vacina.service.impl;

import com.fiap.hackathon.ms_postos_vacina.controller.mapper.PostoResponseMapper;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoUpdateRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;
import com.fiap.hackathon.ms_postos_vacina.exception.PostoNotFoundException;
import com.fiap.hackathon.ms_postos_vacina.repository.EnderecoRepository;
import com.fiap.hackathon.ms_postos_vacina.repository.FuncionamentoRepository;
import com.fiap.hackathon.ms_postos_vacina.repository.PostoRepository;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.EnderecoEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.PostoEntity;
import com.fiap.hackathon.ms_postos_vacina.repository.mapper.EnderecoMapper;
import com.fiap.hackathon.ms_postos_vacina.repository.mapper.FuncionamentoMapper;
import com.fiap.hackathon.ms_postos_vacina.repository.mapper.PostoMapper;
import com.fiap.hackathon.ms_postos_vacina.service.PostoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private EnderecoMapper enderecoMapper;
    @Autowired
    private FuncionamentoMapper funcionamentoMapper;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private FuncionamentoRepository funcionamentoRepository;

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
    public List<PostoResponse> buscaPorBairro(String bairro) {
        return postoRepository.findByEnderecoBairro(bairro)
                .stream()
                .map(postoResponseMapper::toPostoResponse)
                .toList();
    }

    @Transactional
    @Override
    public PostoResponse criaPosto(PostoRequest request) {
        EnderecoEntity endereco = enderecoMapper.toEndereco(request.endereco());
        PostoEntity posto = postoMapper.toPosto(request);

        // TODO: Alterar para que o endereço que tenha o ID do posto e nao ao contrário
        // TODO: O endereço que depende do cadastro do posto e não ao contrário
        posto.setEndereco(endereco);
        posto.getFuncionamento().forEach(f -> f.setPosto(posto));

        PostoEntity postoSaved = postoRepository.save(posto);
        return postoResponseMapper.toPostoResponse(postoSaved);
    }

    @Override
    public PostoResponse atualizaPosto(Long id, PostoUpdateRequest postoUpdateRequest) {
        var posto = postoRepository.findById(id)
                .orElseThrow(PostoNotFoundException::new);

        posto.setNome(postoUpdateRequest.nome());
        posto.setStatus(postoUpdateRequest.statusPostoEnum());
        return postoResponseMapper.toPostoResponse(postoRepository.save(posto));
    }

}
