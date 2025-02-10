package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.enums.DiasSemanaEnum;

import java.time.LocalTime;

import static java.util.Objects.requireNonNull;

public class FuncionamentoDomain implements Funcionamento {
    private final DiasSemanaEnum diaSemana;
    private final LocalTime horarioInicio;
    private final LocalTime horarioFim;

    public FuncionamentoDomain(final String diaSemana, final String horarioInicio, final String horarioFim) {
        requireNonNull(diaSemana, "Dia Semana cannot be null");
        this.diaSemana = DiasSemanaEnum.valueOf(diaSemana.toUpperCase());

        requireNonNull(horarioInicio, "Horario Inicio cannot be null");
        this.horarioInicio = LocalTime.parse(horarioInicio);

        requireNonNull(horarioFim, "Horario Fim cannot be null");
        this.horarioFim = LocalTime.parse(horarioFim);
    }

    @Override
    public String getDiaSemana() {
        return diaSemana.name();
    }

    @Override
    public String getHorarioInicio() {
        return horarioInicio.toString();
    }

    @Override
    public String getHorarioFim() {
        return horarioFim.toString();
    }
}
