package com.br.fiap.application.dto.response;

import com.br.fiap.core.enums.TipoPacienteEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DependenteResponse {

    private TipoPacienteEnum tipo;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private Long enderecoId;

    private LocalDate dataNascimento;

    private String numeroCarteirinhaSUS;

}
