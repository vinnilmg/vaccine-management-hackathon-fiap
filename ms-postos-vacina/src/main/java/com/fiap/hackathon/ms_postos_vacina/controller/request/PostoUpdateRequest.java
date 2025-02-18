package com.fiap.hackathon.ms_postos_vacina.controller.request;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.StatusPostoEnum;

import java.util.List;

public record PostoUpdateRequest(
        String nome,
        List<FuncionamentoRequest> funcionamentoRequestList,
        StatusPostoEnum statusPostoEnum
) {
}
