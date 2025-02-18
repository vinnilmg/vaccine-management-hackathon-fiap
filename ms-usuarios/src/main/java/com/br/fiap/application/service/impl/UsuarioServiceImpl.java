package com.br.fiap.application.service.impl;

import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.dto.response.UsuarioResponse;
import com.br.fiap.application.service.EnderecoService;
import com.br.fiap.application.service.MovimentacaoVacinaService;
import com.br.fiap.core.entity.EnderecoData;
import com.br.fiap.core.enums.TipoPacienteEnum;
import com.br.fiap.core.mapper.EnderecoMapper;
import com.br.fiap.core.mapper.UsuarioMapper;
import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.application.exception.NotFoundException;
import com.br.fiap.application.exception.ValidationException;
import com.br.fiap.application.service.UsuarioService;
import com.br.fiap.application.utils.DataUtils;
import com.br.fiap.core.entity.UsuarioData;
import com.br.fiap.core.model.Usuario;
import com.br.fiap.core.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    private final EnderecoService enderecoService;

    private final EnderecoMapper enderecoMapper;

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toModel)
                .toList();
    }

    public List<MovimentacaoVacinaResponse> getAllMovimentacoesVacinByVacinaIdAndUserId(Long id, Long vacinaId) {
        Usuario usuarioData = usuarioRepository.findById(id)
                .map(usuarioMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Usuario com ID %s não encontrado", id)));

        return usuarioData.getMovimentacaoVacinal().stream()
                .filter(movimentacao -> movimentacao.getVacinaId().equals(vacinaId))
                .map(movimentacaoVacina -> MovimentacaoVacinaResponse.builder()
                        .id(movimentacaoVacina.getId())
                        .vacinaId(movimentacaoVacina.getVacinaId())
                        .sequence(movimentacaoVacina.getSequence())
                        .dataAplicacao(movimentacaoVacina.getDataAplicacao())
                        .localId(movimentacaoVacina.getLocalId())
                        .usuarioId(movimentacaoVacina.getUsuario().getId())
                        .build())
                .toList();

    }

    @Override
    public UsuarioResponse getById(Long id) {
        Usuario usuarioData = usuarioRepository.findById(id)
                .map(usuarioMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Usuario com ID %s não encontrado", id)));

        List<Long> dependentesId = new ArrayList<>();

        usuarioData.getDependentes().stream().forEach(usuario -> dependentesId.add(usuario.getId()));

        if (usuarioData.getTipo().equals(TipoPacienteEnum.TITULAR)) {
            return UsuarioResponse.builder()
                    .dependentesId(dependentesId)
                    .nome(usuarioData.getNome())
                    .cpf(usuarioData.getCpf())
                    .telefone(usuarioData.getTelefone())
                    .email(usuarioData.getEmail())
                    .dataNascimento(usuarioData.getDataNascimento())
                    .tipo(usuarioData.getTipo())
                    .numeroCarteirinhaSUS(usuarioData.getNumeroCarteirinhaSUS())
                    .build();
        }

        return UsuarioResponse.builder()
                .dependentesId(dependentesId)
                .nome(usuarioData.getNome())
                .cpf(usuarioData.getCpf())
                .telefone(usuarioData.getTelefone())
                .email(usuarioData.getEmail())
                .dependenteDeId(usuarioData.getDependenteDe().getId())
                .dataNascimento(usuarioData.getDataNascimento())
                .tipo(usuarioData.getTipo())
                .numeroCarteirinhaSUS(usuarioData.getNumeroCarteirinhaSUS())
                .build();
    }

    @Override
    @Transactional
    public Usuario create(UsuarioRequest usuarioRequest) {

        UsuarioData usuarioData = getUsuarioDataByTipoPessoa(usuarioRequest);
        usuarioData = usuarioRepository.save(usuarioData);
        return usuarioMapper.toModel(usuarioData);
    }

    public UsuarioData getUsuarioDataByTipoPessoa(UsuarioRequest usuarioRequest) {

        EnderecoData enderecoData = enderecoMapper.toData(enderecoService.create(usuarioRequest.endereco()));

        if (Objects.nonNull(usuarioRequest.dependenteDeId()) && usuarioRequest.tipo().equals(TipoPacienteEnum.DEPENDENTE)) {
            validateUserTitularAge(usuarioRequest.dependenteDeId());

            UsuarioData titular = usuarioRepository.findById(usuarioRequest.dependenteDeId())
                    .orElseThrow(() -> new NotFoundException(String.format("Titular com ID %s não encontrado", usuarioRequest.dependenteDeId())));

            return UsuarioData.builder()
                    .cpf(usuarioRequest.cpf())
                    .nome(usuarioRequest.nome())
                    .telefone(usuarioRequest.telefone())
                    .email(usuarioRequest.email())
                    .dataNascimento(usuarioRequest.dataNascimento())
                    .tipo(usuarioRequest.tipo())
                    .numeroCarteirinhaSUS(usuarioRequest.numeroCarteirinhaSUS())
                    .endereco(enderecoData)
                    .dependenteDe(titular)
                    .build();

        } else if (Objects.isNull(usuarioRequest.dependenteDeId()) && usuarioRequest.tipo().equals(TipoPacienteEnum.TITULAR)) {

            return UsuarioData.builder()
                    .cpf(usuarioRequest.cpf())
                    .nome(usuarioRequest.nome())
                    .telefone(usuarioRequest.telefone())
                    .email(usuarioRequest.email())
                    .dataNascimento(usuarioRequest.dataNascimento())
                    .tipo(usuarioRequest.tipo())
                    .numeroCarteirinhaSUS(usuarioRequest.numeroCarteirinhaSUS())
                    .endereco(enderecoData)
                    .build();

        } else if (Objects.isNull(usuarioRequest.dependenteDeId()) && usuarioRequest.tipo().equals(TipoPacienteEnum.DEPENDENTE)) {
            throw new ValidationException("dependenteDe", String.format("Tipo de usuário é %s e seu campo o seu titular está nulo", TipoPacienteEnum.DEPENDENTE));
        }
        throw new ErrorResponseException(HttpStatusCode.valueOf(500));
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
        Usuario usuario = usuarioRepository.findById(id)
                .map(usuarioMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Usuario com ID %s não encontrado", id)));
        if (DataUtils.calculateYearBorn(usuario.getDataNascimento()) < 18) {
            throw new ValidationException("dataNascimento", String.format("Usuário titular ID %s não pode ser cadastrado. nome %s , não tem 18 anos de idade", id, usuario.getNome()));
        }
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
