package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.Funcionamento;
import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.enums.DiaSemanaEnum;
import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.lote.Lote;
import com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

public class PostoVacinacaoComLotesDomain implements PostoVacinacaoComLotes {
    private final Long id;
    private final String nome;
    private final List<Funcionamento> funcionamento;
    private final List<Lote> lotes;

    public PostoVacinacaoComLotesDomain(
            final Long id,
            final String nome,
            final List<Funcionamento> funcionamento
    ) {
        this.id = requireNonNull(id, "Id cannot be null");
        this.nome = requireNonNull(nome, "Nome cannot be null");
        this.funcionamento = requireNonNull(funcionamento, "Funcionamento cannot be null");
        this.lotes = new ArrayList<>();
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
    public List<Funcionamento> getFuncionamento() {
        return funcionamento;
    }

    @Override
    public boolean isOpen(final LocalDateTime dataHoraAgendamento) {
        final var dataAgendamento = dataHoraAgendamento.toLocalDate();
        final var dataAtual = LocalDateTime.now().toLocalDate();

        if (dataAgendamento.isBefore(dataAtual) || dataAgendamento.equals(dataAtual)) {
            throw new CustomValidationException("Data de Agendamento", "menor ou igual a data atual");
        }

        final var diaSemana = DiaSemanaEnum.of(dataHoraAgendamento.getDayOfWeek())
                .orElseThrow(() -> new CustomValidationException("Dia da semana", "não identificado"));

        final var horario = dataHoraAgendamento.toLocalTime();

        return funcionamento.stream()
                .filter(func -> func.compare(diaSemana))
                .findFirst()
                .map(func -> func.isOpen(horario))
                .orElse(false);
    }

    @Override
    public boolean isClosed(LocalDateTime dataHoraAgendamento) {
        return !isOpen(dataHoraAgendamento);
    }

    @Override
    public List<Lote> getLotes() {
        return lotes;
    }

    @Override
    public Optional<Lote> getLote(final Long vacinaId) {
        return lotes.stream()
                .filter(lote -> lote.getVacinaId().equals(vacinaId))
                .findFirst();
    }

    @Override
    public void putLote(final Lote lote) {
        if (nonNull(lote)) this.lotes.add(lote);
    }

    @Override
    public boolean isContainsStock(final Long vacinaId, final LocalDateTime dataAgendamento) {
        if (lotes.isEmpty()) return false;

        return lotes.stream()
                .filter(lote -> lote.getVacinaId().equals(vacinaId))
                .map(lote -> lote.containsEstoque() && lote.isNoExpired(dataAgendamento.toLocalDate()))
                .findFirst()
                .orElse(false);
    }

    @Override
    public boolean isNoContainsStock(final Long vacinaId, final LocalDateTime dataAgendamento) {
        return !isContainsStock(vacinaId, dataAgendamento);
    }
}
