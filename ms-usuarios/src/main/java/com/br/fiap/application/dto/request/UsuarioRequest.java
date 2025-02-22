package com.br.fiap.application.dto.request;

import com.br.fiap.core.enums.TipoPacienteEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioRequest {


    @NotBlank(message = "O nome não pode ser em branco")
    @Size(max = 255, message = "O nome deve ter no máximo 255 caracteres")
    private String nome;

    @NotBlank(message = "O CPF não pode ser em branco")
    @CPF
    private String cpf;

    @NotBlank(message = "O e-mail não pode ser em branco")
    @Size(max = 255, message = "O e-mail deve ter no máximo 255 caracteres")
    private String email;

    @NotBlank(message = "O telefone não pode ser em branco")
    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
    private String telefone;

    private Long enderecoId;

    @Past(message = "A data de nascimento deve ser anterior à data atual")
    private LocalDate dataNascimento;

    @NotBlank(message = "O número da carteirinha do SUS não pode ser em branco")
    @Size(max = 50, message = "O número da carteirinha do SUS deve ter no máximo 50 caracteres")
    private String numeroCarteirinhaSUS;

    @NotNull(message = "O tipo de paciente não pode ser nulo")
    private TipoPacienteEnum tipo;

    @NotNull(message = "Endereço não pode ser nulo")
    private EnderecoRequest endereco;

    private Long dependenteDeId;

    private List<Long> dependentesIds;
}
