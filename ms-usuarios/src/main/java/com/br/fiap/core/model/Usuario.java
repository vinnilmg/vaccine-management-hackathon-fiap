package com.br.fiap.core.model;

import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.application.exception.ValidationException;
import com.br.fiap.core.entity.EnderecoData;
import com.br.fiap.core.enums.TipoPacienteEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private Endereco endereco;

    private LocalDate dataNascimento;

    private String numeroCarteirinhaSUS;

    private TipoPacienteEnum tipo;

    private Usuario dependenteDe;

    private List<Usuario> dependentesList;

    private List<MovimentacaoVacina> movimentacaoVacinal;

    public boolean checkIfUserHasDependente() {
        return !dependentesList.isEmpty();
    }

    public Usuario updateUserFrom(UsuarioRequest usuarioRequest) {
        this.setNome(usuarioRequest.getNome());
        this.setCpf(usuarioRequest.getCpf());
        this.setEmail(usuarioRequest.getEmail());
        this.setDataNascimento(usuarioRequest.getDataNascimento());
        this.setTipo(usuarioRequest.getTipo());
        this.setNumeroCarteirinhaSUS(usuarioRequest.getNumeroCarteirinhaSUS());
        return this;
    }

    public boolean isMaxDependentes() {
        if (Objects.nonNull(this.dependentesList) && this.tipo.equals(TipoPacienteEnum.TITULAR)) {
            return dependentesList.size() >= 10;
        } else if(this.tipo.equals(TipoPacienteEnum.DEPENDENTE)) {
            return dependenteDe.isMaxDependentes();
        }
        return false;
    }

}
