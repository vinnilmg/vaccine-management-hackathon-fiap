package com.br.fiap.application.dto.response;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record MovimentacaoVacinaResponse(Long id,
                                         Integer sequence,
                                         Long vacinaId,
                                         LocalDate dataAplicacao,
                                         Long localId,
                                         Long usuarioId) {
}
