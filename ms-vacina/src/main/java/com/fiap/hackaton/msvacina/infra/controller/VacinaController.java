package com.fiap.hackaton.msvacina.infra.controller;

import com.fiap.hackaton.msvacina.application.usecases.*;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;
import com.fiap.hackaton.msvacina.infra.controller.dto.request.VacinaRequest;
import com.fiap.hackaton.msvacina.infra.controller.dto.response.VacinaResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vacina")
public class VacinaController {

    private final ModelMapper modelMapper;
    private final CreateVacinaUseCase createVacinaUseCase;
    private final FindAllVacinaUseCase findAllVacinaUseCase;
    private final FindVacinaByIdUseCase findVacinaByIdUseCase;
    private final DeleteVacinaUseCase deleteVacinaUseCase;
    private final UpdateVacinaUseCase updateVacinaUseCase;

    public VacinaController(ModelMapper modelMapper, CreateVacinaUseCase createVacinaUseCase, FindAllVacinaUseCase findAllVacinaUseCase, FindVacinaByIdUseCase findVacinaByIdUseCase, DeleteVacinaUseCase deleteVacinaUseCase, UpdateVacinaUseCase updateVacinaUseCase) {
        this.modelMapper = modelMapper;
        this.createVacinaUseCase = createVacinaUseCase;
        this.findAllVacinaUseCase = findAllVacinaUseCase;
        this.findVacinaByIdUseCase = findVacinaByIdUseCase;
        this.deleteVacinaUseCase = deleteVacinaUseCase;
        this.updateVacinaUseCase = updateVacinaUseCase;
    }

    @GetMapping
    public ResponseEntity<List<VacinaResponse>> findAllVacinas() {
        var vacinas = findAllVacinaUseCase.findAll();
        return ResponseEntity.ok().body(vacinas.stream().map(vacina -> modelMapper.map(vacina, VacinaResponse.class)).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacinaResponse> findVacinaById(@PathVariable UUID id) {
        final var request = findVacinaByIdUseCase.findById(id);
        return ResponseEntity.status(200).body(modelMapper.map(request, VacinaResponse.class));
    }

    @PostMapping()
    public ResponseEntity<VacinaResponse> createVacina(@RequestBody VacinaRequest vacinaRequest) {
        var request = modelMapper.map(vacinaRequest, VacinaDomain.class);
        request = createVacinaUseCase.create(request);
        return ResponseEntity.status(201).body(modelMapper.map(request, VacinaResponse.class));
    }

    @DeleteMapping("/{id}")
    public void deleteVacina(@PathVariable UUID id) {
        deleteVacinaUseCase.delete(id);
    }

    @PutMapping("/{id}")
    public VacinaResponse updateVacina(@PathVariable Long id, @RequestBody VacinaRequest vacinaRequest) {
        return null;
    }
}
