package com.fiap.hackathon.ms_postos_vacina.controller.request;

public record EnderecoRequest(
        String rua,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {

}
