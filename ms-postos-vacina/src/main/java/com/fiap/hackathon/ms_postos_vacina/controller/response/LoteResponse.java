package com.fiap.hackathon.ms_postos_vacina.controller.response;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.StatusPostoEnum;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.TipoLocalEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoteResponse {
    private Long id;
    private String numero;
    private Long postoVacinacaoId;
    private Long vacinaId;
    private String validade;
    private Long estoque;
}
