package com.fiap.hackathon.agendamento.domain.entities;

import com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento;

import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

public class AgendamentoDomain implements Agendamento {
    private final Long id;
    private final Long usuarioId;
    private final Long postoVacinacaoId;
    private final Long vacinaId;
    private final StatusAgendamento status;
    private final LocalDateTime dataHoraAgendamento;

    public AgendamentoDomain(
            final Long id,
            final Long usuarioId,
            final Long postoVacinacaoId,
            final Long vacinaId,
            final StatusAgendamento status,
            final LocalDateTime dataHoraAgendamento
    ) {
        this.id = requireNonNull(id, "Id cannot be null");
        this.usuarioId = requireNonNull(usuarioId, "Usuario Id cannot be null");
        this.postoVacinacaoId = requireNonNull(postoVacinacaoId, "Posto Vacinacao Id cannot be null");
        this.vacinaId = requireNonNull(vacinaId, "Vacina Id cannot be null");
        this.status = requireNonNull(status, "Status cannot be null");
        this.dataHoraAgendamento = requireNonNull(dataHoraAgendamento, "Data Hora Agendamento cannot be null");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getUsuarioId() {
        return usuarioId;
    }

    @Override
    public Long getPostoVacinacaoId() {
        return postoVacinacaoId;
    }

    @Override
    public Long getVacinaId() {
        return vacinaId;
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    @Override
    public String getData() {
        return dataHoraAgendamento.toLocalDate().toString();
    }

    @Override
    public String getHora() {
        return dataHoraAgendamento.toLocalTime().toString();
    }

    @Override
    public String getDataHora() {
        return dataHoraAgendamento.toString();
    }
}
