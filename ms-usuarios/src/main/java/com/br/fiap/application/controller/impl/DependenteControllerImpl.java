package com.br.fiap.application.controller.impl;

import com.br.fiap.application.controller.DependenteController;
import com.br.fiap.application.dto.request.DependenteRequest;
import com.br.fiap.application.service.DependenteService;
import com.br.fiap.core.model.Dependente;
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
@RequestMapping("/api/v1/dependente")
@AllArgsConstructor
public class DependenteControllerImpl implements DependenteController {

    private final DependenteService dependenteService;

    @Override
    @GetMapping
    public ResponseEntity<List<Dependente>> getAllDependentes() {
        List<Dependente> dependentes = dependenteService.getAllDependentes();
        return ResponseEntity.ok(dependentes);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Dependente> getDependenteById(@PathVariable Long id) {
        Dependente dependente = dependenteService.getDependenteById(id);
        return ResponseEntity.ok(dependente);
    }

    @Override
    @PostMapping
    public ResponseEntity<Dependente> createDependente(@RequestBody DependenteRequest dependenteRequest) {
        Dependente dependente = dependenteService.create(dependenteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(dependente);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Dependente> updateDependente(@PathVariable Long id, @RequestBody DependenteRequest dependenteRequest) {
        Dependente dependente = dependenteService.update(id, dependenteRequest);
        return ResponseEntity.ok(dependente);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDependente(@PathVariable Long id) {
        dependenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
