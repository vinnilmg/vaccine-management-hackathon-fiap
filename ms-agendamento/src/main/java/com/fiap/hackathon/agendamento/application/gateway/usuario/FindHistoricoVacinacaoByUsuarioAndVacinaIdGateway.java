package com.fiap.hackathon.agendamento.application.gateway.usuario;

import com.fiap.hackathon.agendamento.domain.entities.usuario.historico.HistoricoCompleto;

@FunctionalInterface
public interface FindHistoricoVacinacaoByUsuarioAndVacinaIdGateway {
    HistoricoCompleto find(Long usuarioId, Long vacinaId);
}
