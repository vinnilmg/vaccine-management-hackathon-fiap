package com.br.fiap.application.dto.request;

import com.br.fiap.core.enums.TipoPacienteEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UsuarioRequest(Long id,

                             String nome,

                             String cpf,

                             String email,

                             String telefone,

                             Long enderecoId,

                             LocalDate dataNascimento,

                             String numeroCarteirinhaSUS,

                             TipoPacienteEnum tipo,
                             EnderecoRequest endereco,
                             Long dependenteDeId) {
}
