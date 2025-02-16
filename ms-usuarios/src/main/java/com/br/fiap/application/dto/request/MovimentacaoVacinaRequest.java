package com.br.fiap.application.dto.request;

import java.time.LocalDate;

public record MovimentacaoVacinaRequest(String identificadorVacina,
                                        LocalDate dataAplicacao,
                                        String identificadorLocal,
                                        Long enderecoId,
                                        Long usuarioId,
                                        Long dependenteId) {
}
