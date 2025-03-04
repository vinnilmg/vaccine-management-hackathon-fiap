package com.fiap.hackathon.agendamento.domain.entities.agendamento;

import com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException;
import com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento;

import java.time.LocalDateTime;

import static com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento.CANCELADO;
import static com.fiap.hackathon.agendamento.infra.persistence.entities.enums.StatusAgendamento.FINALIZADO;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.requireNonNull;

public class AgendamentoDomain implements Agendamento {
    private Long id;
    private final Long usuarioId;
    private final Long postoVacinacaoId;
    private final Long vacinaId;
    private final LocalDateTime dataHoraAgendamento;
    private StatusAgendamento status;

    public static Agendamento ofNovoAgendamento(
            final Long usuarioId,
            final Long postoVacinacaoId,
            final Long vacinaId,
            final LocalDateTime dataHoraAgendamento
    ) {
        return new AgendamentoDomain(usuarioId, postoVacinacaoId, vacinaId, dataHoraAgendamento);
    }

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

    private AgendamentoDomain(
            final Long usuarioId,
            final Long postoVacinacaoId,
            final Long vacinaId,
            final LocalDateTime dataHoraAgendamento
    ) {
        this.usuarioId = requireNonNull(usuarioId, "Usuario Id cannot be null");
        this.postoVacinacaoId = requireNonNull(postoVacinacaoId, "Posto Vacinacao Id cannot be null");
        this.vacinaId = requireNonNull(vacinaId, "Vacina Id cannot be null");
        this.status = StatusAgendamento.CONFIRMADO;
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
    public StatusAgendamento getStatusEnum() {
        return status;
    }

    @Override
    public String getData() {
        return dataHoraAgendamento.toLocalDate().toString();
    }

    @Override
    public String getDataFormatada() {
        return dataHoraAgendamento.toLocalDate()
                .format(ofPattern("dd/MM/yyyy"));
    }

    @Override
    public String getHora() {
        return dataHoraAgendamento.toLocalTime().toString();
    }

    @Override
    public String getDataHora() {
        return dataHoraAgendamento.toString();
    }

    @Override
    public void cancelar() {
        switch (status) {
            case CANCELADO:
                throw CustomValidationException.ofAgendamento("already canceled");
            case FINALIZADO:
                throw CustomValidationException.ofAgendamento("is finished, so cannot be canceled");
            case CONFIRMADO:
                status = CANCELADO;
                break;
        }
    }

    @Override
    public void finalizar() {
        switch (status) {
            case CANCELADO:
                throw CustomValidationException.ofAgendamento("is canceled, so cannot be finished");
            case FINALIZADO:
                throw CustomValidationException.ofAgendamento("already finished");
            case CONFIRMADO:
                status = FINALIZADO;
                break;
        }
    }

    @Override
    public boolean isSameDay(final LocalDateTime dataAgendamento) {
        return dataAgendamento.toLocalDate().isEqual(this.dataHoraAgendamento.toLocalDate());
    }
}
