package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.enums;

import java.time.DayOfWeek;
import java.util.Optional;

public enum DiaSemanaEnum {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA,
    SABADO,
    DOMINGO;

    public static Optional<DiaSemanaEnum> of(final DayOfWeek dayOfWeek) {
        return Optional.of(
                switch (dayOfWeek) {
                    case MONDAY -> SEGUNDA;
                    case TUESDAY -> TERCA;
                    case WEDNESDAY -> QUARTA;
                    case THURSDAY -> QUINTA;
                    case FRIDAY -> SEXTA;
                    case SATURDAY -> SABADO;
                    case SUNDAY -> DOMINGO;
                }
        );
    }
}
