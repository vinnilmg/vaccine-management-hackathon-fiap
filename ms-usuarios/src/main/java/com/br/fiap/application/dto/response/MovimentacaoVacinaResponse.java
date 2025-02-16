package com.br.fiap.application.dto.response;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record MovimentacaoVacinaResponse(Integer sequence,
                                         String identificadorVacina,
                                         LocalDate dataAplicacao,
                                         String identificadorLocal,
                                         Long usuarioId,
                                         Long dependenteId) {
}
