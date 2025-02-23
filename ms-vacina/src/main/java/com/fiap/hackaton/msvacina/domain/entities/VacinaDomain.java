package com.fiap.hackaton.msvacina.domain.entities;

public class VacinaDomain implements Vacina{

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

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getDoencasPrevinidas() {
        return doencasPrevinidas;
    }

    public void setDoencasPrevinidas(String doencasPrevinidas) {
        this.doencasPrevinidas = doencasPrevinidas;
    }

    @Override
    public int getNumeroDoses() {
        return numeroDoses;
    }

    public void setNumeroDoses(int numeroDoses) {
        this.numeroDoses = numeroDoses;
    }

    @Override
    public int getIntervaloDoses() {
        return intervaloDoses;
    }

    public void setIntervaloDoses(int intervaloDoses) {
        this.intervaloDoses = intervaloDoses;
    }

    @Override
    public int getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    @Override
    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    @Override
    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    @Override
    public String getEfeitosColaterais() {
        return efeitosColaterais;
    }

    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }
}
