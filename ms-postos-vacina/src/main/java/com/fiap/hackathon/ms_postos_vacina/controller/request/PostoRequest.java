package com.fiap.hackathon.ms_postos_vacina.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostoRequest {
    private String nome;
    private String enderecoId;
    private String tipoLocal;
    private List<String> funcionamentoList;
}
