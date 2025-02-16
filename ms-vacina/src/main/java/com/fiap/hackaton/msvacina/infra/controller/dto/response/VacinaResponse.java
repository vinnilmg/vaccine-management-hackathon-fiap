package com.fiap.hackaton.msvacina.infra.controller.dto.response;

import java.util.UUID;

public class VacinaResponse {

    private UUID id;
    private String nome;
    private String fabricante;
    private String tipo;
    private String doencasPrevinidas;
    private int numeroDoses;
    private int intervaloDoses;
    private int idadeMinima;
    private int idadeMaxima;
    private String contraIndicacoes;
    private String efeitosColaterais;

    public VacinaResponse() {
    }

    public VacinaResponse(UUID id, String nome, String fabricante, String tipo, String doencasPrevinidas, int numeroDoses, int intervaloDoses, int idadeMinima, int idadeMaxima, String contraIndicacoes, String efeitosColaterais) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.doencasPrevinidas = doencasPrevinidas;
        this.numeroDoses = numeroDoses;
        this.intervaloDoses = intervaloDoses;
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
        this.contraIndicacoes = contraIndicacoes;
        this.efeitosColaterais = efeitosColaterais;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDoencasPrevinidas() {
        return doencasPrevinidas;
    }

    public void setDoencasPrevinidas(String doencasPrevinidas) {
        this.doencasPrevinidas = doencasPrevinidas;
    }

    public int getNumeroDoses() {
        return numeroDoses;
    }

    public void setNumeroDoses(int numeroDoses) {
        this.numeroDoses = numeroDoses;
    }

    public int getIntervaloDoses() {
        return intervaloDoses;
    }

    public void setIntervaloDoses(int intervaloDoses) {
        this.intervaloDoses = intervaloDoses;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public String getEfeitosColaterais() {
        return efeitosColaterais;
    }

    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }
}
