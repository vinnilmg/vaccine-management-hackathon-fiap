package com.br.fiap.application.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnderecoRequest(
        Long id,
        String rua,
        String numero,
        String bairro,
        String complemento,
        String cidade,
        String estado,
        String cep) {
}
