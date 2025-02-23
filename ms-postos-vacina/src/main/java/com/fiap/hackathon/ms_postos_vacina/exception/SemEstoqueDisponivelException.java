package com.fiap.hackathon.ms_postos_vacina.exception;

public class SemEstoqueDisponivelException extends RuntimeException{
    public SemEstoqueDisponivelException() {
        super("O lote informado está sem estoque disponível para ser reduzido.");
    }
}
