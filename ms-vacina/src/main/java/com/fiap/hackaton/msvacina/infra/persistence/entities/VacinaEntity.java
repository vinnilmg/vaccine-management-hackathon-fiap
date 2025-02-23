package com.fiap.hackaton.msvacina.infra.persistence.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "vacinas")
public class VacinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
