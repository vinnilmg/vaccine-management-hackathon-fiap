package com.br.fiap.application.dto.response;

import com.br.fiap.core.enums.TipoPacienteEnum;
import com.br.fiap.core.model.Endereco;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
@Builder
public record UsuarioResponse( String nome,

         String cpf,

         String email,

         String telefone,

         Endereco endereco,

         LocalDate dataNascimento,

         String numeroCarteirinhaSUS,

         TipoPacienteEnum tipo,

         Long dependenteDeId,

         List<Long>dependentesId) {
}
