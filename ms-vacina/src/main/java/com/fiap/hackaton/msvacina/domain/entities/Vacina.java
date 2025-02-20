package com.fiap.hackaton.msvacina.domain.entities;

import java.util.List;
import java.util.UUID;

public interface Vacina {

    UUID getId();
    String getNome();
    String getFabricante();
    String getTipo();
    List<String> getDoencasPrevinidas();
    int getNumeroDoses();
    int getIntervaloDoses();
    int getIdadeMinima();
    int getIdadeMaxima();
    String getContraIndicacoes();
    List<String> getEfeitosColaterais();
}
