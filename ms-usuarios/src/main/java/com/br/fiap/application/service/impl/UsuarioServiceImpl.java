package com.br.fiap.application.service.impl;

import com.br.fiap.application.dto.request.EnderecoRequest;
import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.application.dto.response.DependenteResponse;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.dto.response.UsuarioResponse;
import com.br.fiap.application.exception.NotFoundException;
import com.br.fiap.application.exception.ValidationException;
import com.br.fiap.application.mapper.DependenteMapper;
import com.br.fiap.application.service.EnderecoService;
import com.br.fiap.application.service.UsuarioService;
import com.br.fiap.application.utils.DataUtils;
import com.br.fiap.core.entity.UsuarioData;
import com.br.fiap.core.enums.TipoPacienteEnum;
import com.br.fiap.core.mapper.EnderecoMapper;
import com.br.fiap.core.mapper.MovimentacaoVacinaMapper;
import com.br.fiap.core.mapper.UsuarioMapper;
import com.br.fiap.core.model.Endereco;
import com.br.fiap.core.model.Usuario;
import com.br.fiap.core.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    private final EnderecoService enderecoService;

    private final MovimentacaoVacinaMapper movimentacaoVacinaMapper;

    private final DependenteMapper dependenteMapper;

    private final EnderecoMapper enderecoMapper;

    @Override
    public List<UsuarioResponse> getAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toResponse)
                .toList();
    }

    public List<MovimentacaoVacinaResponse> getAllMovimentacoesVacinByVacinaIdAndUserId(Long id, Long vacinaId) {
        Usuario usuario = findById(id);
        return usuario.getMovimentacaoVacinal().stream()
                .filter(movimentacao -> movimentacao.getVacinaId().equals(vacinaId))
                .map(movimentacaoVacinaMapper::toResponse)
                .toList();
    }

    @Override
    public List<DependenteResponse> getAllDependentesByUserId(Long userId) {
        return findById(userId)
                .getDependentesList()
                .stream()
                .map(dependenteMapper::toResponse)
                .toList();
    }

    @Override
    public UsuarioResponse getById(Long id) {
        Usuario usuarioData = findById(id);
        return usuarioMapper.toResponse(usuarioData);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toModel)
                .orElseThrow(() -> new NotFoundException(String.format("Usuario com ID %s não encontrado", id)));
    }

    @Override
    @Transactional
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Usuario usuario = getUsuarioDataByTipoPessoa(usuarioRequest);
        var usuarioData = usuarioRepository.save(usuarioMapper.toData(usuario));
        return usuarioMapper.toResponse(usuarioData);
    }

    public Usuario getUsuarioDataByTipoPessoa(UsuarioRequest usuarioRequest) {

        Endereco enderecoToSave = enderecoService.create(usuarioRequest.getEndereco());

        validateUserTitularAge(usuarioRequest.getDependenteDeId(),usuarioRequest);

        Optional<Usuario> titular = Objects.nonNull(usuarioRequest.getDependenteDeId()) ? Optional.of(findById(usuarioRequest.getDependenteDeId()))
                : Optional.empty();

       return usuarioRequest.getTipo().createModel(enderecoToSave,titular,usuarioRequest);

    }

    @Override
    @Transactional
    public UsuarioResponse update(Long id, UsuarioRequest usuarioRequest) {
        Usuario usuario = findById(id);

        if(Objects.isNull(usuarioRequest)) {
            throw new ValidationException("UserRequest","UserRequest está nulo.");
        }

        usuario = usuario.updateUserFrom(usuarioRequest);
        setEnderecoForUser(usuario, usuarioRequest.getEndereco());
        setDependentesIsTitular(usuario,usuarioRequest);
        setDependentesDeIsDependente(usuario,usuarioRequest);

        UsuarioData updatedUsuario = usuarioRepository.save(usuarioMapper.toData(usuario));
        return usuarioMapper.toResponse(updatedUsuario);
    }

    public void setEnderecoForUser(Usuario usuario, EnderecoRequest enderecoRequest) {
        if (Objects.nonNull(enderecoRequest)) {
            Endereco endereco = enderecoService.create(enderecoRequest);
            enderecoService.delete(usuario.getEndereco().getId());
            usuario.setEndereco(endereco);
        }
    }

    public void setDependentesIsTitular(Usuario usuario, UsuarioRequest usuarioRequest) {
        if(usuario.getTipo().equals(TipoPacienteEnum.TITULAR)) {
            List<Usuario> usuariosDependentes = usuarioRequest.getDependentesIds()
                    .stream()
                    .map(this::findById)
                    .toList();

            checkIfHasTitularFromDependentes(usuariosDependentes);
            usuario.setDependentesList(usuariosDependentes);
        }
   }

    public void setDependentesDeIsDependente(Usuario usuario, UsuarioRequest usuarioRequest) {
        if(usuario.getTipo().equals(TipoPacienteEnum.DEPENDENTE)) {
            Usuario dependenteDe = findById(usuarioRequest.getDependenteDeId());
            usuario.setDependenteDe(dependenteDe);
        }
    }

private void checkIfHasTitularFromDependentes(List<Usuario> dependentesList) {
    Optional<Usuario> titularFilter = dependentesList.stream()
            .filter(usuarioFilter -> usuarioFilter.getTipo().equals(TipoPacienteEnum.TITULAR))
            .findAny();
    titularFilter.ifPresent(titular -> {
        throw new ValidationException("dependentesList", "Existe titular na lista de dependentes");
    });
}

    @Override
    public void validateUserTitularAge(Long id, UsuarioRequest usuarioRequest) {
        if (usuarioRequest.getTipo().equals(TipoPacienteEnum.DEPENDENTE) && Objects.nonNull(usuarioRequest.getDependenteDeId())) {
            Usuario usuario = findById(id);
            if (DataUtils.calculateYearBorn(usuario.getDataNascimento()) < 18) {
                throw new ValidationException("dataNascimento", String.format("Usuário titular ID %s não pode ser cadastrado. nome %s , não tem 18 anos de idade", id, usuario.getNome()));
            }
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Usuario usuario = findById(id);
        validateDependentes(usuario);
        enderecoService.delete(usuario.getEndereco().getId());
        usuarioRepository.deleteById(id);
    }

    private void validateDependentes(Usuario usuario) {
        if (usuario.checkIfUserHasDependente()) {
            throw new ValidationException("dependentesList", String.format("User %s contém dependentes, por isso não pode ser deletado!", usuario.getId()));
        }
    }
}
