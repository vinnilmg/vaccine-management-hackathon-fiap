package com.fiap.hackathon.ms_postos_vacina.repository.entity;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.StatusPostoEnum;
import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.TipoLocalEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posto")
public class PostoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

    @Enumerated(EnumType.STRING)
    private TipoLocalEnum tipoLocal;

    @OneToMany(mappedBy = "posto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<FuncionamentoEntity> funcionamento;

    @Enumerated(EnumType.STRING)
    private StatusPostoEnum status;
}
