package com.fiap.hackathon.ms_postos_vacina.controller.request;

import java.util.List;

public record PostoRequest(
        String nome,
        EnderecoRequest endereco,
        String tipoLocal,
        List<FuncionamentoRequest> funcionamento
) {
}
