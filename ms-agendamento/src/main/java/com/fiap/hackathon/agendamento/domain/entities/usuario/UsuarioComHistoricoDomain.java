package com.fiap.hackathon.agendamento.domain.entities.usuario;

import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoCompleto;
import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoVacinacao;
import com.fiap.hackathon.agendamento.domain.entities.vacina.Vacina;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

public class UsuarioComHistoricoDomain implements UsuarioComHistorico {
    private final Long id;
    private final String nome;
    private final String email;
    private final String cpf;
    private final String numeroCarteira;
    private HistoricoCompleto historico;

    public UsuarioComHistoricoDomain(
            final Long id,
            final String nome,
            final String email,
            final String cpf,
            final String numeroCarteira
    ) {
        this.id = requireNonNull(id, "Id cannot be null");
        this.nome = requireNonNull(nome, "Nome cannot be null");
        this.email = requireNonNull(email, "Email cannot be null");
        this.cpf = requireNonNull(cpf, "Cpf cannot be null");
        this.numeroCarteira = requireNonNull(numeroCarteira, "Numero Carteira cannot be null");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    @Override
    public HistoricoCompleto getHistorico() {
        return historico;
    }

    @Override
    public void putHistorico(final HistoricoCompleto historico) {
        this.historico = historico;
    }

    @Override
    public boolean containsHistorico() {
        return nonNull(historico) && historico.isExists();
    }

    @Override
    public boolean isCanGetAVaccine(final Vacina vacina, final LocalDateTime dataHoraAgendamento) {
        requireNonNull(vacina, "Vacina cannot be null");
        requireNonNull(dataHoraAgendamento, "Data Hora Agendamento cannot be null");

        if (!containsHistorico()) return true;

        final var historicoByVacina = historico.getHistorico()
                .stream()
                .filter(hist -> hist.getVacinaId().equals(vacina.getId()))
                .toList();

        if (historicoByVacina.size() >= vacina.getDoses()) return false;

        final var dataAgendamento = dataHoraAgendamento.toLocalDate();

        return historicoByVacina.stream()
                .map(HistoricoVacinacao::getData)
                .max(LocalDate::compareTo)
                .map(dataUltimaDose -> !dataUltimaDose.plusDays(vacina.getIntervalo()).isAfter(dataAgendamento))
                .orElse(true);
    }

    @Override
    public boolean isCannotGetAVaccine(final Vacina vacina, final LocalDateTime dataHoraAgendamento) {
        return !isCanGetAVaccine(vacina, dataHoraAgendamento);
    }
}
