package com.fiap.hackathon.agendamento.infra.persistence.entities;

import com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "agendamentos")
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataHoraAgendamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @NotNull
    private Long postoVacinacaoId;

    @NotNull
    private Long vacinaId;

    @NotNull
    private Long usuarioId;
}
