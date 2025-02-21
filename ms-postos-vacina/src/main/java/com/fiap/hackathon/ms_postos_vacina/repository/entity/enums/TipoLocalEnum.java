package com.fiap.hackathon.ms_postos_vacina.repository.entity.enums;

import java.util.stream.Stream;

public enum TipoLocalEnum {
    UBS,
    HOSPITAL,
    MOVEL;

    public static TipoLocalEnum toEnum(final String value) {
        return Stream.of(values())
                .filter(tipoLocal -> tipoLocal.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de local inválido"));
    }
}
