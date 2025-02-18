package com.br.fiap.application.controller.impl;

import com.br.fiap.application.controller.UsuarioController;
import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.dto.response.UsuarioResponse;
import com.br.fiap.application.service.UsuarioService;
import com.br.fiap.core.model.Usuario;
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
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    @Override
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAll();
        return ResponseEntity.ok(usuarios);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable Long id) {
        UsuarioResponse usuario = usuarioService.getById(id);
        return ResponseEntity.ok(usuario);
    }

    @Override
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.create(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.update(id, usuarioRequest);
        return ResponseEntity.ok(usuario);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/{id}/vacinaId/{idVacina}")
    public ResponseEntity<List<MovimentacaoVacinaResponse>> getAllMovimentacoesVacinByVacinaIdAndUserId(@PathVariable Long id,@PathVariable Long idVacina) {
         List<MovimentacaoVacinaResponse> movimentacaoVacinaResponseList = usuarioService.getAllMovimentacoesVacinByVacinaIdAndUserId(id,idVacina);
         return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoVacinaResponseList);
    }

}
