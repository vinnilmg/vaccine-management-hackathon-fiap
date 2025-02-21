package com.br.fiap.application.dto.response;

import com.br.fiap.core.enums.TipoPacienteEnum;
import com.br.fiap.core.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioResponse {

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private Long enderecoId;

    private LocalDate dataNascimento;

    private String numeroCarteirinhaSUS;

    private TipoPacienteEnum tipo;

    private Long dependenteDeId;

    private List<Long> dependentesListid;
}
