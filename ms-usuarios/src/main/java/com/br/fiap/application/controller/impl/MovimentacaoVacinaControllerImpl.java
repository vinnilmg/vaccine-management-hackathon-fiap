package com.br.fiap.application.controller.impl;

import com.br.fiap.application.controller.MovimentacaoVacinaController;
import com.br.fiap.application.dto.request.MovimentacaoVacinaRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.service.MovimentacaoVacinaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimentacao-vacina")
@AllArgsConstructor
public class MovimentacaoVacinaControllerImpl implements MovimentacaoVacinaController {

    private final MovimentacaoVacinaService movimentacaoVacinaService;

    @Override
    @GetMapping
    public ResponseEntity<List<MovimentacaoVacinaResponse>> getAllMovimentacoes() {
        return ResponseEntity.ok(movimentacaoVacinaService.getAllMovimentacoes());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MovimentacaoVacinaResponse> getMovimentacaoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoVacinaService.getMovimentacaoById(id));
    }

    @Override
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<MovimentacaoVacinaResponse>> getMovimentacaoByIdUsuario(@PathVariable Long id) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoVacinaService.getAlltMovimentacaoByUsuarioId(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<MovimentacaoVacinaResponse> createMovimentacao(@RequestBody MovimentacaoVacinaRequest movimentacaoVacina) {
        MovimentacaoVacinaResponse createdMovimentacao = movimentacaoVacinaService.create(movimentacaoVacina);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovimentacao);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<MovimentacaoVacinaResponse> updateMovimentacao(@PathVariable Long id, @RequestBody MovimentacaoVacinaRequest movimentacaoVacina) {
        MovimentacaoVacinaResponse updatedMovimentacao = movimentacaoVacinaService.update(id, movimentacaoVacina);
        return ResponseEntity.ok(updatedMovimentacao);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimentacao(@PathVariable Long id) {
        movimentacaoVacinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
