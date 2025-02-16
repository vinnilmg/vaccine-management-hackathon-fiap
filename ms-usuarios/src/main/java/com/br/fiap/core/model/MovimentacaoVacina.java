package com.br.fiap.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimentacaoVacina {

     private Long id;

     private Integer sequence;

     private String identificadorVacina;

     private LocalDate dataAplicacao;

     private String identificadorLocal;

     private Usuario usuario;

     private Dependente dependente;

}
