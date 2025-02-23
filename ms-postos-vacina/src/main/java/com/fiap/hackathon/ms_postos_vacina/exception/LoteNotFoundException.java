package com.fiap.hackathon.ms_postos_vacina.exception;

public class LoteNotFoundException extends RuntimeException {
    public LoteNotFoundException() {
        super("Número do lote não encontrado.");
    }
}
