package com.br.fiap.core.model;

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

    private List<Usuario> dependentes;

    private List<MovimentacaoVacina> movimentacaoVacinal;
}
