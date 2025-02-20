package com.fiap.hackathon.agendamento.domain.entities.usuario;

import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoCompleto;
import com.fiap.hackathon.agendamento.domain.entities.vacina.Vacina;

import java.time.LocalDateTime;

public interface UsuarioComHistorico extends Usuario {

    HistoricoCompleto getHistorico();

    void putHistorico(HistoricoCompleto historico);

    boolean containsHistorico();

    boolean isCanGetAVaccine(Vacina vacina, LocalDateTime dataHoraAgendamento);

    boolean isCannotGetAVaccine(Vacina vacina, LocalDateTime dataHoraAgendamento);
}
