package com.br.fiap.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

     private Long id;

     private String rua;

     private String numero;

     private String bairro;

     private String complemento;

     private String cidade;

     private String estado;

     private  String cep;
}
