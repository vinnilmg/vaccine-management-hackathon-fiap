package com.fiap.hackathon.ms_postos_vacina.repository.entity;

import com.fiap.hackathon.ms_postos_vacina.repository.entity.enums.DiasSemanaEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "funcionamento")
public class FuncionamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private DiasSemanaEnum diaSemana;

    @NotBlank
    private String horarioInicio;

    @NotBlank
    private String horarioFim;

    @ManyToOne
    @JoinColumn(name = "posto_id", nullable = false)
    private PostoEntity posto;
}
