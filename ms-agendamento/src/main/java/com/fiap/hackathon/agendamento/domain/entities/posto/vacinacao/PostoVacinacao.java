package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.Funcionamento;
import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina.Vacina;

import java.util.List;

public interface PostoVacinacao {
    Long getId();

    String getNome();

    List<Funcionamento> getFuncionamento();

    Vacina getVacina();
}
