package com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao;

import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.Funcionamento;
import com.fiap.hackathon.agendamento.domain.entities.posto.vacinacao.funcionamento.enums.DiaSemanaEnum;
import com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class PostoVacinacaoDomain implements PostoVacinacao {
    private final Long id;
    private final String nome;
    private final List<Funcionamento> funcionamento;
    //private final Vacina vacina;

    public PostoVacinacaoDomain(
            final Long id,
            final String nome,
            final List<Funcionamento> funcionamento
            //final Vacina vacina
    ) {
        this.id = requireNonNull(id, "Id cannot be null");
        this.nome = requireNonNull(nome, "Nome cannot be null");
        this.funcionamento = requireNonNull(funcionamento, "Funcionamento cannot be null");
        //this.vacina = requireNonNull(vacina, "Vacina cannot be null");
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

    /*@Override
    public Vacina getVacina() {
        return vacina;
    }*/
}
