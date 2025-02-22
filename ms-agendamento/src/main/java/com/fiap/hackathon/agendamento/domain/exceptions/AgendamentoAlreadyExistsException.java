package com.fiap.hackathon.agendamento.domain.exceptions;

public class AgendamentoAlreadyExistsException extends RuntimeException {
    private static final String ALREADY_EXISTS_AGENDAMENTO_TO_SAME_USER_AND_VACINA_MSG = "Já existe um agendamento confirmado para o mesmo usuario e vacina.";
    private static final String ALREADY_EXISTS_AGENDAMENTO_TO_SAME_DAY_MSG = "Já existe um agendamento confirmado para este dia.";

    public static AgendamentoAlreadyExistsException ofAlreadyExistsByUserAndVacina() {
        return new AgendamentoAlreadyExistsException(ALREADY_EXISTS_AGENDAMENTO_TO_SAME_USER_AND_VACINA_MSG);
    }

    public static AgendamentoAlreadyExistsException ofAlreadyExistsBySameDay() {
        return new AgendamentoAlreadyExistsException(ALREADY_EXISTS_AGENDAMENTO_TO_SAME_DAY_MSG);
    }

    public AgendamentoAlreadyExistsException(final String msg) {
        super(msg);
    }
}
