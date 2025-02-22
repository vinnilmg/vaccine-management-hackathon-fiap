package com.br.fiap.application.service.impl;

import com.br.fiap.application.dto.request.MovimentacaoVacinaRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.exception.NotFoundException;
import com.br.fiap.application.exception.ValidationException;
import com.br.fiap.application.service.MovimentacaoVacinaService;
import com.br.fiap.application.service.UsuarioService;
import com.br.fiap.core.entity.MovimentacaoVacinaData;
import com.br.fiap.core.mapper.MovimentacaoVacinaMapper;
import com.br.fiap.core.model.MovimentacaoVacina;
import com.br.fiap.core.model.Usuario;
import com.br.fiap.core.repository.MovimentacaoVacinaRepository;
import com.br.fiap.infrasctructure.client.VacinaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimentacaoVacinaServiceImpl implements MovimentacaoVacinaService {

    private final MovimentacaoVacinaRepository movimentacaoVacinaRepository;
    private final UsuarioService usuarioService;
    private final MovimentacaoVacinaMapper movimentacaoVacinaMapper;
    private final VacinaClient vacinaClient;

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

        Usuario usuario = usuarioService.findById(movimentacaoVacinaRequest.getUsuarioId());

        vacinaClient.getVacinaById(movimentacaoVacinaRequest.getVacinaId()).orElseThrow(() -> new ValidationException("vacinaClient",
                String.format("Vacina ID %s não existe.",movimentacaoVacinaRequest.getVacinaId())));

        MovimentacaoVacina movimentacaoVacina = MovimentacaoVacina.builder()
                .vacinaId(movimentacaoVacinaRequest.getVacinaId())
                .dataAplicacao(movimentacaoVacinaRequest.getData())
                .usuario(usuario)
                .localId(movimentacaoVacinaRequest.getLocalId())
                .build();

        MovimentacaoVacinaData movimentacaoVacinaData = movimentacaoVacinaRepository.save(movimentacaoVacinaMapper.toData(movimentacaoVacina));

        return movimentacaoVacinaMapper.toResponse(movimentacaoVacinaData);
    }

    @Override
    public MovimentacaoVacinaResponse update(Long id, MovimentacaoVacinaRequest movimentacaoVacinaRequest) {

        Usuario usuario = usuarioService.findById(movimentacaoVacinaRequest.getUsuarioId());

        vacinaClient.getVacinaById(movimentacaoVacinaRequest.getVacinaId()).orElseThrow(() -> new ValidationException("vacinaClient",
                String.format("Vacina ID %s não existe.",movimentacaoVacinaRequest.getVacinaId())));

        MovimentacaoVacina movimentacaoVacina = movimentacaoVacinaRepository.findById(id)
                .map(movimentacaoVacinaMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Movimentação Vacina com o ID %s não encontrada", id)));

        movimentacaoVacina.setVacinaId(movimentacaoVacinaRequest.getVacinaId());
        movimentacaoVacina.setDataAplicacao(movimentacaoVacinaRequest.getData());
        movimentacaoVacina.setLocalId(movimentacaoVacinaRequest.getLocalId());
        movimentacaoVacina.setUsuario(usuario);

        MovimentacaoVacinaData movimentacaoVacinaData = movimentacaoVacinaRepository.save(movimentacaoVacinaMapper.toData(movimentacaoVacina));

        return movimentacaoVacinaMapper.toResponse(movimentacaoVacinaData);
    }

    @Override
    public List<MovimentacaoVacinaResponse> getAllMovimentacaoVacinaDependentesByUserId(Long idUsuario) {
        Usuario usuario = usuarioService.findById(idUsuario);
        return movimentacaoVacinaRepository.findAllByUsuarioId(usuario.getDependentesList().stream()
                        .map(Usuario::getId)
                        .toList())
                .stream()
                .map(movimentacaoVacinaMapper::toResponse)
                .sorted(Comparator.comparing(MovimentacaoVacinaResponse::getUsuarioId))
                .toList();
    }

    @Override
    public void delete(Long id) {
        movimentacaoVacinaRepository.deleteById(id);
    }

}
