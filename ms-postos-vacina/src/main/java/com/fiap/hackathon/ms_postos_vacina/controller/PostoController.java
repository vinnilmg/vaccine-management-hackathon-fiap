package com.fiap.hackathon.ms_postos_vacina.controller;

import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;
import com.fiap.hackathon.ms_postos_vacina.service.PostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/postos")
@RestController
public class PostoController {
    @Autowired
    private PostoService postoService;

    @GetMapping
    public ResponseEntity<List<PostoResponse>> buscaPostos() {
        return ResponseEntity.ok(postoService.buscaPostos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostoResponse> buscaPosto(@PathVariable Long id) {
        return ResponseEntity.ok(postoService.buscaPosto(id));
    }

    @GetMapping("/bairro")
    public ResponseEntity<List<PostoResponse>> buscaPorBairro(@RequestParam String bairro) {
        return ResponseEntity.ok(postoService.buscaPorBairro(bairro));
    }

    @PostMapping
    public ResponseEntity<PostoResponse> criaPosto(@RequestBody PostoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postoService.criaPosto(request));
    }


}
