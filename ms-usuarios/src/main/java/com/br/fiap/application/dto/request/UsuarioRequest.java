package com.br.fiap.application.dto.request;

import com.br.fiap.core.enums.TipoPacienteEnum;

import java.time.LocalDate;

public record UsuarioRequest(Long id,

                             String nome,

                             String cpf,

                             String email,

                             String telefone,

                             Long enderecoId,

                             LocalDate dataNascimento,

                             String numeroCarteirinhaSUS,

                             TipoPacienteEnum tipo) {
}
