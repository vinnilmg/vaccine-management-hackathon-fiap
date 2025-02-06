package com.fiap.hackathon.agendamento.application.gateway;

import com.fiap.hackathon.agendamento.domain.entities.Agendamento;

import java.util.List;

@FunctionalInterface
public interface FindByPostoVacinacaoGateway {
    List<Agendamento> find(Long postoVacinacaoId);
}
