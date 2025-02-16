package com.fiap.hackathon.ms_postos_vacina.repository.entity;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.StatusPostoEnum;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.TipoLocalEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posto")
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private TipoLocalEnum tipoLocal;

    @OneToMany
    @JoinColumn(name = "funcionamento_id", referencedColumnName = "id")
    private List<Funcionamento> funcionamento;

    @Enumerated(EnumType.STRING)
    private StatusPostoEnum status;
}
