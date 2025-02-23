package com.fiap.hackathon.ms_postos_vacina.exception;

public class EstoqueInvalidoException extends RuntimeException {
    public EstoqueInvalidoException() {
        super("Estoque tem que ser maior que 0.");
    }
}
