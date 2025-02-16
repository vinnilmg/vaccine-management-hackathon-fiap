package com.br.fiap.application.service.impl;

import com.br.fiap.application.dto.request.MovimentacaoVacinaRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.exception.NotFoundException;
import com.br.fiap.application.exception.ValidationException;
import com.br.fiap.application.service.DependenteService;
import com.br.fiap.application.service.MovimentacaoVacinaService;
import com.br.fiap.application.service.UsuarioService;
import com.br.fiap.core.entity.MovimentacaoVacinaData;
import com.br.fiap.core.mapper.MovimentacaoVacinaMapper;
import com.br.fiap.core.model.Dependente;
import com.br.fiap.core.model.MovimentacaoVacina;
import com.br.fiap.core.model.Usuario;
import com.br.fiap.core.repository.MovimentacaoVacinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
@RequiredArgsConstructor
public class MovimentacaoVacinaServiceImpl implements MovimentacaoVacinaService {
    private final MovimentacaoVacinaRepository movimentacaoVacinaRepository;
    private final UsuarioService usuarioService;
    private final DependenteService dependenteService;
    private final MovimentacaoVacinaMapper movimentacaoVacinaMapper;

    @Override
    public List<MovimentacaoVacina> getAllMovimentacoes() {
        return movimentacaoVacinaRepository.findAll()
                .stream()
                .map(movimentacaoVacinaMapper::toModel)
                .toList();
    }

    @Override
    public MovimentacaoVacina getMovimentacaoById(Long id) {
        return movimentacaoVacinaRepository.findById(id)
                .map(movimentacaoVacinaMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Movimentação Vacina com o ID %s não encontrada", id)));
    }

    @Override
    public MovimentacaoVacinaResponse create(MovimentacaoVacinaRequest movimentacaoVacinaRequest) {

        MovimentacaoVacina movimentacaoVacina = movimentacaoVacinaMapper.toModel(createdByUsuarioValidation(movimentacaoVacinaRequest));

        return MovimentacaoVacinaResponse.builder()
                .sequence(movimentacaoVacina.getSequence())
                .identificadorVacina(movimentacaoVacina.getIdentificadorVacina())
                .dataAplicacao(movimentacaoVacina.getDataAplicacao())
                .identificadorLocal(movimentacaoVacina.getIdentificadorLocal())
                .dependenteId(movimentacaoVacina.getDependente().getId())
                .usuarioId(movimentacaoVacina.getUsuario().getId())
                .build();
    }

    @Override
    public MovimentacaoVacinaResponse update(Long id, MovimentacaoVacinaRequest movimentacaoVacinaRequest) {

        MovimentacaoVacina movimentacaoVacina = movimentacaoVacinaMapper.toModel(updateByUsuarioValidation(id, movimentacaoVacinaRequest));

        return MovimentacaoVacinaResponse.builder()
                .sequence(movimentacaoVacina.getSequence())
                .identificadorVacina(movimentacaoVacina.getIdentificadorVacina())
                .dataAplicacao(movimentacaoVacina.getDataAplicacao())
                .identificadorLocal(movimentacaoVacina.getIdentificadorLocal())
                .dependenteId(movimentacaoVacina.getDependente().getId())
                .usuarioId(movimentacaoVacina.getUsuario().getId())
                .build();
    }

    private MovimentacaoVacinaData updateByUsuarioValidation(Long id, MovimentacaoVacinaRequest movimentacaoVacinaRequest) {

        if (Objects.nonNull(movimentacaoVacinaRequest.usuarioId())) {

            Usuario usuario = usuarioService.getById(movimentacaoVacinaRequest.usuarioId());

            MovimentacaoVacina movimentacao = getMovimentacaoById(id);
            movimentacao.setIdentificadorVacina(movimentacaoVacinaRequest.identificadorVacina());
            movimentacao.setDataAplicacao(movimentacaoVacinaRequest.dataAplicacao());
            movimentacao.setIdentificadorLocal(movimentacaoVacinaRequest.identificadorLocal());
            movimentacao.setUsuario(usuario);

            return movimentacaoVacinaRepository.save(movimentacaoVacinaMapper.toData(movimentacao));

        } else if (Objects.nonNull(movimentacaoVacinaRequest.dependenteId())) {
            return updateByDependente(id, movimentacaoVacinaRequest);
        }
        throw new ValidationException("updateMovimentacaoVacina", "Error updateByUsuarioValidation");
    }

    private MovimentacaoVacinaData updateByDependente(Long id, MovimentacaoVacinaRequest movimentacaoVacinaRequest) {

        Dependente dependente = dependenteService.getDependenteById(movimentacaoVacinaRequest.dependenteId());

        MovimentacaoVacina movimentacao = getMovimentacaoById(id);
        movimentacao.setIdentificadorVacina(movimentacaoVacinaRequest.identificadorVacina());
        movimentacao.setDataAplicacao(movimentacaoVacinaRequest.dataAplicacao());
        movimentacao.setIdentificadorLocal(movimentacaoVacinaRequest.identificadorLocal());
        movimentacao.setDependente(dependente);

        return movimentacaoVacinaRepository.save(movimentacaoVacinaMapper.toData(movimentacao));
    }

    @Override
    public void delete(Long id) {
        movimentacaoVacinaRepository.deleteById(id);
    }

    private MovimentacaoVacinaData createdByUsuarioValidation(MovimentacaoVacinaRequest movimentacaoVacinaRequest) {

        if (Objects.nonNull(movimentacaoVacinaRequest.dependenteId())) {
            Dependente dependente = dependenteService.getDependenteById(movimentacaoVacinaRequest.dependenteId());

            MovimentacaoVacina movimentacaoVacina = MovimentacaoVacina.builder()
                    .identificadorVacina(movimentacaoVacinaRequest.identificadorVacina())
                    .dependente(dependente)
                    .dataAplicacao(movimentacaoVacinaRequest.dataAplicacao())
                    .identificadorLocal(movimentacaoVacinaRequest.identificadorLocal())
                    .build();

            return movimentacaoVacinaRepository.save(movimentacaoVacinaMapper.toData(movimentacaoVacina));

        } else if (Objects.nonNull(movimentacaoVacinaRequest.usuarioId())) {
            return createdByUsuario(movimentacaoVacinaRequest);
        }
        throw new ValidationException("persistMovimentacaoVacina", "Error createdByValidation");
    }

    private MovimentacaoVacinaData createdByUsuario(MovimentacaoVacinaRequest movimentacaoVacinaRequest) {

        Usuario usuario = usuarioService.getById(movimentacaoVacinaRequest.usuarioId());

        MovimentacaoVacina movimentacaoVacina = MovimentacaoVacina.builder()
                .identificadorVacina(movimentacaoVacinaRequest.identificadorVacina())
                .usuario(usuario)
                .dataAplicacao(movimentacaoVacinaRequest.dataAplicacao())
                .identificadorLocal(movimentacaoVacinaRequest.identificadorLocal())
                .build();

        return movimentacaoVacinaRepository.save(movimentacaoVacinaMapper.toData(movimentacaoVacina));


    }
}
