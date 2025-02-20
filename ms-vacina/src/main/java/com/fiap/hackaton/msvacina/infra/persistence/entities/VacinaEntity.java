package com.fiap.hackaton.msvacina.infra.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "vacinas")
public class VacinaEntity {

    @Id
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
}
