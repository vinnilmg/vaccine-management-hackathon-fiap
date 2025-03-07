package com.br.fiap.application.dto.response;

import com.br.fiap.core.enums.TipoPacienteEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioResponse {
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private Long enderecoId;

    private LocalDate dataNascimento;

    private String numeroCarteirinhaSUS;

    private TipoPacienteEnum tipo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long dependenteDeId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Long> dependentesListid;
}
