package com.fiap.hackathon.agendamento.domain.exceptions;

public class AgendamentoAlreayExistsException extends RuntimeException {
    private static final String MESSAGE = "Ja existe um agendamento confirmado para o mesmo usuario e vacina";

    public static AgendamentoAlreayExistsException of() {
        return new AgendamentoAlreayExistsException();
    }

    public AgendamentoAlreayExistsException() {
        super(MESSAGE);
    }
}
