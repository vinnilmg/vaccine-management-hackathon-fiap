package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.enums;

import java.time.DayOfWeek;
import java.util.Optional;

public enum DiaSemanaEnum {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA;

    public static Optional<DiaSemanaEnum> of(final DayOfWeek dayOfWeek) {
        return Optional.ofNullable(
                switch (dayOfWeek) {
                    case MONDAY -> SEGUNDA;
                    case TUESDAY -> TERCA;
                    case WEDNESDAY -> QUARTA;
                    case THURSDAY -> QUINTA;
                    case FRIDAY -> SEXTA;
                    default -> null;
                }
        );
    }
}
