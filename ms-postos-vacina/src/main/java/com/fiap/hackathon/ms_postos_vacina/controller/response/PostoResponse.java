package com.fiap.hackathon.ms_postos_vacina.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.StatusPostoEnum;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.TipoLocalEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostoResponse {
    private Long id;
    private String nome;
    private EnderecoResponse endereco;
    private TipoLocalEnum tipoLocal;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FuncionamentoResponse> funcionamento;
    private StatusPostoEnum status;
}
