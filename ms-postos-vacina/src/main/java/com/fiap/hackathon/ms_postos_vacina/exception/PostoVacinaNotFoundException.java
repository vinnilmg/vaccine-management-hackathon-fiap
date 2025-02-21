package com.fiap.hackathon.ms_postos_vacina.exception;

public class PostoVacinaNotFoundException extends RuntimeException {
    public PostoVacinaNotFoundException() {
        super("Vacina não encontrada no posto.");
    }
}

