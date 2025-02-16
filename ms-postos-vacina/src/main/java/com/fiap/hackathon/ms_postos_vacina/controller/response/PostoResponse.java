package com.fiap.hackathon.ms_postos_vacina.controller.response;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.Endereco;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.Funcionamento;
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
    private Endereco endereco;
    private TipoLocalEnum tipoLocal;
    private List<Funcionamento> funcionamento;
    private StatusPostoEnum status;
}
