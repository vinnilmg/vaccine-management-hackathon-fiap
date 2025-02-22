package com.br.fiap.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovimentacaoVacinaRequest {
    private Long vacinaId;
    private LocalDate data;
    private Long localId;
    private Long usuarioId;
}
