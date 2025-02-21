package com.fiap.hackathon.ms_postos_vacina.repository.entity.enums;

import java.util.stream.Stream;

public enum DiasSemanaEnum {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA,
    SABADO;

    public static DiasSemanaEnum toEnum(final String value) {
        return Stream.of(values())
                .filter(diaSemana -> diaSemana.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dia da semana inválido"));
    }
}
