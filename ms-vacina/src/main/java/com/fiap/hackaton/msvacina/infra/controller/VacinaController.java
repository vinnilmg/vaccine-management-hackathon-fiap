package com.fiap.hackaton.msvacina.infra.controller;

import com.fiap.hackaton.msvacina.application.usecases.CreateVacinaUseCase;
import com.fiap.hackaton.msvacina.application.usecases.DeleteVacinaUseCase;
import com.fiap.hackaton.msvacina.application.usecases.FindAllVacinaUseCase;
import com.fiap.hackaton.msvacina.application.usecases.FindVacinaByIdUseCase;
import com.fiap.hackaton.msvacina.application.usecases.UpdateVacinaUseCase;
import com.fiap.hackaton.msvacina.domain.entities.VacinaDomain;
import com.fiap.hackaton.msvacina.infra.controller.dto.request.VacinaRequest;
import com.fiap.hackaton.msvacina.infra.controller.dto.response.VacinaResponse;
import org.modelmapper.ModelMapper;
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
@RequestMapping("/vacinas")
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
    public ResponseEntity<VacinaResponse> findVacinaById(@PathVariable Long id) {
        final var request = findVacinaByIdUseCase.findById(id);
        return ResponseEntity.status(200).body(modelMapper.map(request, VacinaResponse.class));
    }

    @PostMapping
    public ResponseEntity<VacinaResponse> createVacina(@RequestBody VacinaRequest vacinaRequest) {
        var request = modelMapper.map(vacinaRequest, VacinaDomain.class);
        request = createVacinaUseCase.create(request);
        return ResponseEntity.status(201).body(modelMapper.map(request, VacinaResponse.class));
    }

    @DeleteMapping("/{id}")
    public void deleteVacina(@PathVariable Long id) {
        deleteVacinaUseCase.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacinaResponse> updateVacina(@PathVariable Long id, @RequestBody VacinaRequest vacinaRequest) {
        final var request = modelMapper.map(vacinaRequest, VacinaDomain.class);
        updateVacinaUseCase.update(id, request);

        final var response = modelMapper.map(request, VacinaResponse.class);
        response.setId(id);

        return ResponseEntity.status(200).body(response);
    }
}
