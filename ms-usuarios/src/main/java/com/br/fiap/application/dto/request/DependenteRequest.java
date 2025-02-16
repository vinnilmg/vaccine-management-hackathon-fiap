package com.br.fiap.application.dto;

import java.time.LocalDate;

public record DependenteRequest(String nome,
                                LocalDate dataNascimento,
                                Long enderecoId,
                                String numeroCarteirinhaSUS,
                                Long titularId) {
}
