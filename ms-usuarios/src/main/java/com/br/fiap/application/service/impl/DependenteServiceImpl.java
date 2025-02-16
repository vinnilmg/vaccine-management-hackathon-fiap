package com.br.fiap.application.service.impl;

import com.br.fiap.core.mapper.DependenteMapper;
import com.br.fiap.application.dto.request.DependenteRequest;
import com.br.fiap.application.exception.NotFoundException;
import com.br.fiap.application.service.DependenteService;
import com.br.fiap.application.service.EnderecoService;
import com.br.fiap.application.service.UsuarioService;
import com.br.fiap.core.entity.DependenteData;
import com.br.fiap.core.model.Dependente;
import com.br.fiap.core.model.Endereco;
import com.br.fiap.core.model.Usuario;
import com.br.fiap.core.repository.DependenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DependenteServiceImpl implements DependenteService {

    private final DependenteMapper dependenteMapper;
    private final DependenteRepository dependenteRepository;
    private final UsuarioService usuarioService;
    private final EnderecoService enderecoService;


    @Override
    public List<Dependente> getAllDependentes() {
        return dependenteRepository.findAll()
                .stream()
                .map(dependenteMapper::toModel)
                .toList();
    }

    @Override
    public Dependente getDependenteById(Long id) {
        return dependenteRepository.findById(id)
                .map(dependenteMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Dependente com ID %s não encontrado",id)));
    }

    @Override
    public Dependente create(DependenteRequest dependenteRequest) {
        Endereco endereco = enderecoService.getById(dependenteRequest.enderecoId());
        Usuario usuario = usuarioService.getById(dependenteRequest.titularId());

        usuarioService.validateUserTitularAge(dependenteRequest.titularId());

        Dependente dependente = Dependente.builder()
                .nome(dependenteRequest.nome())
                .endereco(endereco)
                .titular(usuario)
                .dataNascimento(dependenteRequest.dataNascimento())
                .numeroCarteirinhaSUS(dependenteRequest.numeroCarteirinhaSUS())
                .build();

        DependenteData savedDependente = dependenteRepository.save(dependenteMapper.toData(dependente));
        return dependenteMapper.toModel(savedDependente);
    }

    @Override
    public Dependente update(Long id, DependenteRequest dependenteRequest) {
        Usuario usuarioFromDatabase = usuarioService.getById(dependenteRequest.titularId());
        Endereco enderecoFromDatabase = enderecoService.getById(dependenteRequest.enderecoId());

        Dependente dependente = getDependenteById(id);
        dependente.setNome(dependenteRequest.nome());
        dependente.setDataNascimento(dependenteRequest.dataNascimento());
        dependente.setNumeroCarteirinhaSUS(dependenteRequest.numeroCarteirinhaSUS());
        dependente.setTitular(usuarioFromDatabase);
        dependente.setEndereco(enderecoFromDatabase);

        DependenteData updatedDependente = dependenteRepository.save(dependenteMapper.toData(dependente));
        return dependenteMapper.toModel(updatedDependente);
    }

    @Override
    public void delete(Long id) {
        dependenteRepository.deleteById(id);
    }
}
