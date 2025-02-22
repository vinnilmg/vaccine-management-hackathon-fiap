package com.fiap.hackathon.ms_postos_vacina.exception;

public class PostoNotFoundException extends RuntimeException {
    public PostoNotFoundException() {
        super("Posto não existe.");
    }
}
