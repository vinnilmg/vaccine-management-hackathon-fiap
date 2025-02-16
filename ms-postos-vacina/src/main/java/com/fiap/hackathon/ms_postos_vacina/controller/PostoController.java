package com.fiap.hackathon.ms_postos_vacina.controller;

import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;
import com.fiap.hackathon.ms_postos_vacina.service.PostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
