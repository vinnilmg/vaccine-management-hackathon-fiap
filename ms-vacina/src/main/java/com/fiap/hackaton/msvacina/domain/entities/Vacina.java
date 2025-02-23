package com.fiap.hackaton.msvacina.domain.entities;

import java.util.List;
import java.util.UUID;

public interface Vacina {

    Long getId();
    String getNome();
    String getFabricante();
    String getTipo();
    String getDoencasPrevinidas();
    int getNumeroDoses();
    int getIntervaloDoses();
    int getIdadeMinima();
    int getIdadeMaxima();
    String getContraIndicacoes();
    String getEfeitosColaterais();
}
