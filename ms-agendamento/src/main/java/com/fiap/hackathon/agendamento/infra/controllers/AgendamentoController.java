package com.fiap.hackathon.agendamento.infra.controllers;

import com.fiap.hackathon.agendamento.application.usecases.BuscarPorPostoVacinacaoUseCase;
import com.fiap.hackathon.agendamento.application.usecases.BuscarPorUsuarioUseCase;
import com.fiap.hackathon.agendamento.application.usecases.BuscarPorVacinaUseCase;
import com.fiap.hackathon.agendamento.application.usecases.BuscarTodosAgendamentosUseCase;
import com.fiap.hackathon.agendamento.application.usecases.CancelarAgendamentoUseCase;
import com.fiap.hackathon.agendamento.application.usecases.CriarAgendamentoUseCase;
import com.fiap.hackathon.agendamento.application.usecases.FinalizarAgendamentoUseCase;
import com.fiap.hackathon.agendamento.application.usecases.impl.BuscarPorPostoVacinacaoUseCaseImpl;
import com.fiap.hackathon.agendamento.application.usecases.impl.BuscarPorUsuarioUseCaseImpl;
import com.fiap.hackathon.agendamento.application.usecases.impl.BuscarPorVacinaUseCaseImpl;
import com.fiap.hackathon.agendamento.application.usecases.impl.BuscarTodosAgendamentosUseCaseImpl;
import com.fiap.hackathon.agendamento.application.usecases.impl.CancelarAgendamentoUseCaseImpl;
import com.fiap.hackathon.agendamento.application.usecases.impl.CriarAgendamentoUseCaseImpl;
import com.fiap.hackathon.agendamento.application.usecases.impl.FinalizarAgendamentoUseCaseImpl;
import com.fiap.hackathon.agendamento.infra.controllers.mappers.AgendamentoResponseMapper;
import com.fiap.hackathon.agendamento.infra.controllers.request.AgendamentoRequest;
import com.fiap.hackathon.agendamento.infra.controllers.response.AgendamentoResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@Tag(name = "Agendamento", description = "API de Agendamentos")
@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    private final BuscarTodosAgendamentosUseCase buscarTodosAgendamentosUseCase;
    private final BuscarPorPostoVacinacaoUseCase buscarPorPostoVacinacaoUseCase;
    private final BuscarPorUsuarioUseCase buscarPorUsuarioUseCase;
    private final BuscarPorVacinaUseCase buscarPorVacinaUseCase;
    private final CriarAgendamentoUseCase criarAgendamentoUseCase;
    private final CancelarAgendamentoUseCase cancelarAgendamentoUseCase;
    private final FinalizarAgendamentoUseCase finalizarAgendamentoUseCase;
    private final AgendamentoResponseMapper agendamentoResponseMapper;

    public AgendamentoController(
            BuscarTodosAgendamentosUseCaseImpl buscarTodosAgendamentosUseCase,
            BuscarPorPostoVacinacaoUseCaseImpl buscarTodosPorLocalUseCase,
            BuscarPorUsuarioUseCaseImpl buscarPorUsuarioUseCase,
            BuscarPorVacinaUseCaseImpl buscarPorVacinaUseCase,
            CriarAgendamentoUseCaseImpl criarAgendamentoUseCase,
            CancelarAgendamentoUseCaseImpl cancelarAgendamentoUseCase,
            FinalizarAgendamentoUseCaseImpl finalizarAgendamentoUseCase,
            AgendamentoResponseMapper agendamentoResponseMapper
    ) {
        this.buscarTodosAgendamentosUseCase = buscarTodosAgendamentosUseCase;
        this.buscarPorPostoVacinacaoUseCase = buscarTodosPorLocalUseCase;
        this.buscarPorUsuarioUseCase = buscarPorUsuarioUseCase;
        this.buscarPorVacinaUseCase = buscarPorVacinaUseCase;
        this.criarAgendamentoUseCase = criarAgendamentoUseCase;
        this.cancelarAgendamentoUseCase = cancelarAgendamentoUseCase;
        this.finalizarAgendamentoUseCase = finalizarAgendamentoUseCase;
        this.agendamentoResponseMapper = agendamentoResponseMapper;
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponse> realizarAgendamento(
            @Valid @RequestBody final AgendamentoRequest request
    ) {
        final var agendamentoCriado = criarAgendamentoUseCase.execute(request);
        return ResponseEntity.ok(agendamentoResponseMapper.toResponse(agendamentoCriado));
    }

    @PutMapping("/{agendamentoId}/finalizar")
    @ResponseStatus(NO_CONTENT)
    public void finalizarAgendamento(@PathVariable final Long agendamentoId) {
        finalizarAgendamentoUseCase.execute(agendamentoId);
    }

    @PutMapping("/{agendamentoId}/cancelar")
    @ResponseStatus(NO_CONTENT)
    public void cancelarAgendamento(@PathVariable final Long agendamentoId) {
        cancelarAgendamentoUseCase.execute(agendamentoId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<AgendamentoResponse>> buscarTodosPorUsuario(@PathVariable final Long usuarioId) {
        final var agendamentos = buscarPorUsuarioUseCase.execute(usuarioId);
        return ResponseEntity.ok(agendamentoResponseMapper.toResponses(agendamentos));
    }

    @GetMapping("/posto-vacinacao/{postoVacinacaoId}")
    public ResponseEntity<List<AgendamentoResponse>> buscarTodosPorLocal(@PathVariable final Long postoVacinacaoId) {
        final var agendamentos = buscarPorPostoVacinacaoUseCase.execute(postoVacinacaoId);
        return ResponseEntity.ok(agendamentoResponseMapper.toResponses(agendamentos));
    }

    @GetMapping("/vacina/{vacinaId}")
    public ResponseEntity<List<AgendamentoResponse>> buscarPorVacina(@PathVariable final Long vacinaId) {
        final var agendamentos = buscarPorVacinaUseCase.execute(vacinaId);
        return ResponseEntity.ok(agendamentoResponseMapper.toResponses(agendamentos));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> buscarTodos() {
        final var agendamentos = buscarTodosAgendamentosUseCase.execute();
        return ResponseEntity.ok(agendamentoResponseMapper.toResponses(agendamentos));
    }
}
