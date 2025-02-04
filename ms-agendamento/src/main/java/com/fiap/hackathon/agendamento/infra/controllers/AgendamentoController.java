package com.fiap.hackathon.agendamento.infra.controllers;

import com.fiap.hackathon.agendamento.application.usecases.BuscarTodosAgendamentosUseCase;
import com.fiap.hackathon.agendamento.application.usecases.impl.BuscarTodosAgendamentosUseCaseImpl;
import com.fiap.hackathon.agendamento.infra.controllers.request.AgendamentoRequest;
import com.fiap.hackathon.agendamento.infra.persistence.entities.AgendamentoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    private final BuscarTodosAgendamentosUseCase buscarTodosAgendamentosUseCase;

    public AgendamentoController(BuscarTodosAgendamentosUseCaseImpl buscarTodosAgendamentosUseCase) {
        this.buscarTodosAgendamentosUseCase = buscarTodosAgendamentosUseCase;
    }

    @PostMapping
    public ResponseEntity<AgendamentoEntity> realizarAgendamento(@RequestBody final AgendamentoRequest request) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{agendamentoId}/concluir")
    public ResponseEntity<Void> concluirAgendamento(@PathVariable final Long agendamentoId) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{agendamentoId}/cancelar")
    public ResponseEntity<Void> cancelarAgendamento(@PathVariable final Long agendamentoId) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<AgendamentoEntity>> buscarTodosPorUsuario(@PathVariable final Long usuarioId) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/posto-vacinacao/{postoVacinacaoId}")
    public ResponseEntity<List<AgendamentoEntity>> buscarTodosPorLocal(@PathVariable final Long postoVacinacaoId) {
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoEntity>> buscarTodos() {
        return ResponseEntity.ok(buscarTodosAgendamentosUseCase.execute());
    }
}
