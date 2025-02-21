package com.br.fiap.application.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovimentacaoVacinaResponse {
    private Long id;
    private Integer sequence;
    private Long vacinaId;
    private LocalDate dataAplicacao;
    private Long localId;
    private Long usuarioId;
}
