package com.fiap.hackaton.msvacina.domain.entities;

import java.util.List;
import java.util.UUID;

public class VacinaDomain implements Vacina{

    private UUID id;
    private String nome;
    private String fabricante;
    private String tipo;
    private List<String> doencasPrevinidas;
    private int numeroDoses;
    private int intervaloDoses;
    private int idadeMinima;
    private int idadeMaxima;
    private String contraIndicacoes;
    private List<String> efeitosColaterais;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getFabricante() {
        return fabricante;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public List<String> getDoencasPrevinidas() {
        return List.of(doencasPrevinidas.toString());
    }

    @Override
    public int getNumeroDoses() {
        return numeroDoses;
    }

    @Override
    public int getIntervaloDoses() {
        return intervaloDoses;
    }

    @Override
    public int getIdadeMinima() {
        return idadeMinima;
    }

    @Override
    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    @Override
    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    @Override
    public List<String> getEfeitosColaterais() {
        return List.of(efeitosColaterais.toString());
    }
}
