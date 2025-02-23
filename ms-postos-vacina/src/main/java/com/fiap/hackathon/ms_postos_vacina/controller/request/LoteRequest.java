package com.fiap.hackathon.ms_postos_vacina.controller.request;

public record LoteRequest (
        String numero,
        Long postoVacinacaoId,
        Long vacinaId,
        String validade,
        Long estoque
){
}
