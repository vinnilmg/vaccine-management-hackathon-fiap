package com.fiap.hackathon.agendamento.domain.exceptions;

import lombok.Getter;

import static java.text.MessageFormat.format;

@Getter
public class NotFoundException extends RuntimeException {
    private static final String DEFAULT_MSG = "não existe";

    private final String resource;

    public NotFoundException(final String resource) {
        super(DEFAULT_MSG);
        this.resource = resource;
    }

    @Override
    public String getMessage() {
        return format("{0} {1}", resource, super.getMessage());
    }

    public static NotFoundException of(final String resource) {
        return new NotFoundException(resource);
    }

    public static NotFoundException ofAgendamento() {
        return of("Agendamento");
    }

    public static NotFoundException ofPostoVacinacao() {
        return of("Posto de Vacinação");
    }

    public static NotFoundException ofUsuario() {
        return of("Usuário");
    }

    public static NotFoundException ofVacina() {
        return of("Vacina");
    }
}