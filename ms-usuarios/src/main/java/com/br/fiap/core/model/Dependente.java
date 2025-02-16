package com.br.fiap.core.model;

import com.br.fiap.core.entity.MovimentacaoVacinaData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dependente {

     private Long id;

     private String nome;

     private LocalDate dataNascimento;

     private Endereco endereco;

     private String numeroCarteirinhaSUS;

     private Usuario titular;

     private List<MovimentacaoVacina> movimentacaoVacinal;
}
