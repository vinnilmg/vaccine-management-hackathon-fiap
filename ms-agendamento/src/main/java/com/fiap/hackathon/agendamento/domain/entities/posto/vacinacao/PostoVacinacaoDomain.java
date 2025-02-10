package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.Funcionamento;
import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.vacina.Vacina;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class PostoVacinacaoDomain implements PostoVacinacao {
    private final Long id;
    private final String nome;
    private final List<Funcionamento> funcionamento;
    private final Vacina vacina;

    public PostoVacinacaoDomain(
            final Long id,
            final String nome,
            final List<Funcionamento> funcionamento,
            final Vacina vacina
    ) {
        this.id = requireNonNull(id, "Id cannot be null");
        this.nome = requireNonNull(nome, "Nome cannot be null");
        this.funcionamento = requireNonNull(funcionamento, "Funcionamento cannot be null");
        this.vacina = requireNonNull(vacina, "Vacina cannot be null");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public List<Funcionamento> getFuncionamento() {
        return funcionamento;
    }

    @Override
    public Vacina getVacina() {
        return vacina;
    }
}
