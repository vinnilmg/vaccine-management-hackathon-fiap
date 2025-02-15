package com.fiap.hackathon.agendamento.domain.entities.usuario;

import static java.util.Objects.requireNonNull;

public class UsuarioDomain implements Usuario {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String numeroCarteira;

    public UsuarioDomain(final Long id, final String nome, final String email, final String cpf, final String numeroCarteira) {
        this.id = requireNonNull(id, "Id cannot be null");
        this.nome = requireNonNull(nome, "Nome cannot be null");
        this.email = requireNonNull(email, "Email cannot be null");
        this.cpf = requireNonNull(cpf, "Cpf cannot be null");
        this.numeroCarteira = requireNonNull(numeroCarteira, "Numero Carteira cannot be null");
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
    public String getEmail() {
        return email;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public String getNumeroCarteira() {
        return numeroCarteira;
    }
}
