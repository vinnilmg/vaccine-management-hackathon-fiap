package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.Funcionamento;

import java.time.LocalDateTime;
import java.util.List;

public interface PostoVacinacao {
    Long getId();

    String getNome();

    List<Funcionamento> getFuncionamento();

    // Vacina getVacina();

    boolean isOpen(LocalDateTime dataHoraAgendamento);

    boolean isClosed(LocalDateTime dataHoraAgendamento);
}
