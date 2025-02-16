package com.fiap.hackathon.ms_postos_vacina.controller.request;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.Funcionamento;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.StatusPostoEnum;

import java.util.List;

public class PostoUpdateRequest {
    private String nome;
    private List<Funcionamento> funcionamentoList;
    private StatusPostoEnum statusPosto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionamento> getFuncionamentoList() {
        return funcionamentoList;
    }

    public void setFuncionamentoList(List<Funcionamento> funcionamentoList) {
        this.funcionamentoList = funcionamentoList;
    }

    public StatusPostoEnum getStatusPosto() {
        return statusPosto;
    }

    public void setStatusPosto(StatusPostoEnum statusPosto) {
        this.statusPosto = statusPosto;
    }
}
