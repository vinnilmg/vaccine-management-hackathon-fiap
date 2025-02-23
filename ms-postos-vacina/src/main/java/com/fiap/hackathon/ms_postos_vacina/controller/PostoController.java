package com.fiap.hackathon.ms_postos_vacina.controller;

import com.fiap.hackathon.ms_postos_vacina.controller.request.LoteRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.response.LoteResponse;
import com.fiap.hackathon.ms_postos_vacina.controller.request.PostoUpdateRequest;
import com.fiap.hackathon.ms_postos_vacina.controller.response.PostoResponse;
import com.fiap.hackathon.ms_postos_vacina.service.PostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/criar-lote")
    public ResponseEntity<LoteResponse> criaLote(@RequestBody LoteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postoService.criaLote(request));
    }

    @PutMapping("/{idPosto}/vacinas/{vacinaid}/lote/aumentar-etoque")
    public ResponseEntity<Void> aumentarEstoque(@PathVariable Long idPosto, @PathVariable Long vacinaid) {
        postoService.aumentarEstoque(idPosto, vacinaid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idPosto}/vacinas/{vacinaid}/lote/diminuir-estoque")
    public ResponseEntity<Void> diminuirEstoque(@PathVariable Long idPosto, @PathVariable Long vacinaid) {
        postoService.diminuirEstoque(idPosto, vacinaid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idPosto}/vacinas/{vacinaid}/lote")
    public ResponseEntity<LoteResponse> buscaPosto(@PathVariable Long idPosto, @PathVariable Long vacinaid) {
        return ResponseEntity.ok(postoService.buscaPostoLote(idPosto, vacinaid));
    }

    @GetMapping("/lotes/numero/{idlote}")
    public ResponseEntity<LoteResponse> buscaNrLote(@PathVariable String idlote) {
        return ResponseEntity.ok(postoService.buscaNrLote(idlote));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostoResponse> atualizaPosto(@PathVariable Long id,
                                                       @RequestBody PostoUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(postoService.atualizaPosto(id, request));
    }


}
