package com.br.fiap.application.service.impl;

import com.br.fiap.application.dto.request.MovimentacaoVacinaRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.exception.NotFoundException;
import com.br.fiap.application.service.MovimentacaoVacinaService;
import com.br.fiap.application.service.UsuarioService;
import com.br.fiap.core.entity.MovimentacaoVacinaData;
import com.br.fiap.core.mapper.MovimentacaoVacinaMapper;
import com.br.fiap.core.mapper.UsuarioMapper;
import com.br.fiap.core.model.MovimentacaoVacina;
import com.br.fiap.core.model.Usuario;
import com.br.fiap.core.repository.MovimentacaoVacinaRepository;
import com.br.fiap.core.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimentacaoVacinaServiceImpl implements MovimentacaoVacinaService {
    private final MovimentacaoVacinaRepository movimentacaoVacinaRepository;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioService usuarioService;
    private final MovimentacaoVacinaMapper movimentacaoVacinaMapper;

    @Override
    public List<MovimentacaoVacinaResponse> getAllMovimentacoes() {
        return movimentacaoVacinaRepository.findAll()
                .stream()
                .map(movimentacaoVacinaMapper::toResponse)
                .toList();

    }

    @Override
    public MovimentacaoVacina findById(Long id) {
        return movimentacaoVacinaRepository.findById(id)
                .map(movimentacaoVacinaMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Movimentação Vacina com o ID %s não encontrada", id)));

    }

    @Override
    public MovimentacaoVacinaResponse getMovimentacaoById(Long id) {
        MovimentacaoVacina movimentacaoVacina = findById(id);
        return movimentacaoVacinaMapper.toResponse(movimentacaoVacina);
    }
    @Override
    public List<MovimentacaoVacinaResponse> getAlltMovimentacaoByUsuarioId(Long idUsuario) {
        return movimentacaoVacinaRepository.findAllByUsuarioId(idUsuario)
                .stream()
                .map(movimentacaoVacinaMapper::toResponse)
                .toList();
    }

    @Override
    public MovimentacaoVacinaResponse create(MovimentacaoVacinaRequest movimentacaoVacinaRequest) {

        Usuario usuario = usuarioRepository.findById(movimentacaoVacinaRequest.usuarioId())
                .map(usuarioMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Usuario com ID %s não encontrado", movimentacaoVacinaRequest.usuarioId())));

        MovimentacaoVacina movimentacaoVacina = MovimentacaoVacina.builder()
                .vacinaId(movimentacaoVacinaRequest.vacinaId())
                .dataAplicacao(movimentacaoVacinaRequest.data())
                .usuario(usuario)
                .localId(movimentacaoVacinaRequest.localId())
                .build();

        MovimentacaoVacinaData movimentacaoVacinaData = movimentacaoVacinaRepository.save(movimentacaoVacinaMapper.toData(movimentacaoVacina));

        return movimentacaoVacinaMapper.toResponse(movimentacaoVacinaData);
    }

    @Override
    public MovimentacaoVacinaResponse update(Long id, MovimentacaoVacinaRequest movimentacaoVacinaRequest) {

        Usuario usuario = usuarioRepository.findById(movimentacaoVacinaRequest.usuarioId())
                .map(usuarioMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Usuario com ID %s não encontrado", movimentacaoVacinaRequest.usuarioId())));


        MovimentacaoVacina movimentacaoVacina = movimentacaoVacinaRepository.findById(id)
                .map(movimentacaoVacinaMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Movimentação Vacina com o ID %s não encontrada", id)));

        movimentacaoVacina.setVacinaId(movimentacaoVacinaRequest.vacinaId());
        movimentacaoVacina.setDataAplicacao(movimentacaoVacinaRequest.data());
        movimentacaoVacina.setLocalId(movimentacaoVacinaRequest.localId());
        movimentacaoVacina.setUsuario(usuario);

        MovimentacaoVacinaData movimentacaoVacinaData = movimentacaoVacinaRepository.save(movimentacaoVacinaMapper.toData(movimentacaoVacina));

        return movimentacaoVacinaMapper.toResponse(movimentacaoVacinaData);
    }

    @Override
    public void delete(Long id) {
        movimentacaoVacinaRepository.deleteById(id);
    }

}
