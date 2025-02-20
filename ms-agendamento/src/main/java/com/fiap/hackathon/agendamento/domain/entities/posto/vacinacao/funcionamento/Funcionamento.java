package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.enums.DiaSemanaEnum;

import java.time.LocalTime;

public interface Funcionamento {
    String getDiaSemana();

    DiaSemanaEnum getDiaSemanaEnum();

    String getHorarioInicio();

    String getHorarioFim();

    boolean compare(DiaSemanaEnum diaSemanaEnum);

    boolean isOpen(LocalTime horaAgendamento);
}
