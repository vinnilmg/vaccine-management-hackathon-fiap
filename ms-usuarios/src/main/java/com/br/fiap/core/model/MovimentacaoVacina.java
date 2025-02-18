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

     private Long vacinaId;

     private LocalDate dataAplicacao;

     private Long localId;

     private Usuario usuario;

}
