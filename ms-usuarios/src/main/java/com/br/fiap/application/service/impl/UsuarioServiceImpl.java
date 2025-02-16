package com.br.fiap.application.service.impl;

import com.br.fiap.core.mapper.UsuarioMapper;
import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.application.exception.NotFoundException;
import com.br.fiap.application.exception.ValidationException;
import com.br.fiap.application.service.UsuarioService;
import com.br.fiap.application.utils.DataUtils;
import com.br.fiap.core.entity.UsuarioData;
import com.br.fiap.core.model.Usuario;
import com.br.fiap.core.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

     final UsuarioRepository usuarioRepository;
     final UsuarioMapper usuarioMapper;
    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toModel)
                .toList();
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toModel)
                .orElseThrow(() ->   new NotFoundException(String.format("Usuario com ID %s não encontrado", id)));
    }

    @Override
    public Usuario create(UsuarioRequest usuarioRequest) {

        return usuarioMapper.toModel(usuarioRepository.save(UsuarioData.builder()
                .cpf(usuarioRequest.cpf())
                .email(usuarioRequest.email())
                .dataNascimento(usuarioRequest.dataNascimento())
                .tipo(usuarioRequest.tipo())
                .numeroCarteirinhaSUS(usuarioRequest.numeroCarteirinhaSUS())
                .build()));
    }

    @Override
    public Usuario update(Long id, UsuarioRequest usuarioModel) {
        UsuarioData usuarioData = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioData.setCpf(usuarioModel.cpf());
        usuarioData.setEmail(usuarioModel.email());
        usuarioData.setDataNascimento(usuarioModel.dataNascimento());
        usuarioData.setTipo(usuarioModel.tipo());
        usuarioData.setNumeroCarteirinhaSUS(usuarioModel.numeroCarteirinhaSUS());
        UsuarioData updatedUsuario = usuarioRepository.save(usuarioData);
        return usuarioMapper.toModel(updatedUsuario);
    }

    @Override
    public void validateUserTitularAge(Long id) {
        Usuario usuario = getById(id);
        if(DataUtils.calculateYearBorn(usuario.getDataNascimento()) < 18){
            throw new ValidationException("dataNascimento",String.format("Usuário titular ID %s não pode ser cadastrado. nome %s , não tem 18 anos de idade",id,usuario.getNome()));
        }
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
