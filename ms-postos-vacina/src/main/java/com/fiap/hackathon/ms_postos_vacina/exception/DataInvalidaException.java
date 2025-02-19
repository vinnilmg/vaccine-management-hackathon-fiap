package com.fiap.hackathon.ms_postos_vacina.exception;

public class DataInvalidaException extends RuntimeException {
    public DataInvalidaException() {
        super("Data de validade tem que ser maior que a data atual.");
    }
}
