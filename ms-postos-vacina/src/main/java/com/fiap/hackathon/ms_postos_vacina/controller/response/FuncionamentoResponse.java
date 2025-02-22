package com.fiap.hackathon.ms_postos_vacina.controller.response;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.DiasSemanaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionamentoResponse {
    private DiasSemanaEnum diaSemana;
    private String horarioInicio;
    private String horarioFim;
}
