package com.br.fiap.application.dto.request;

import java.time.LocalDate;

public record MovimentacaoVacinaRequest(Long vacinaId,
                                        LocalDate data,
                                        Long localId,
                                        Long usuarioId) {
}
