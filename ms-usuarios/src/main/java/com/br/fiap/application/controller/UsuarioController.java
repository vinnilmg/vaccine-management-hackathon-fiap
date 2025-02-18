package com.br.fiap.application.controller;

import com.br.fiap.application.dto.request.UsuarioRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import com.br.fiap.application.dto.response.UsuarioResponse;
import com.br.fiap.core.model.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Usuario", description = "Operações relacionadas a usuários")

public interface UsuarioController {

    @Operation(
            summary = "Listar todos os usuários",
            description = "Retorna uma lista de todos os usuários cadastrados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<List<Usuario>> getAllUsuarios();

    @Operation(
            summary = "Buscar usuário por ID",
            description = "Retorna um usuário com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<UsuarioResponse> getUsuarioById(Long id);

    @Operation(
            summary = "Criar um novo usuário",
            description = "Cria um novo usuário com os dados fornecidos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<Usuario> createUsuario(UsuarioRequest usuarioRequest);

    @Operation(
            summary = "Atualizar um usuário",
            description = "Atualiza os dados de um usuário existente com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<Usuario> updateUsuario(Long id, UsuarioRequest usuarioRequest);

    @Operation(
            summary = "Excluir um usuário",
            description = "Exclui um usuário com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<Void> deleteUsuario(Long id);

    @Operation(
            summary = "Buscar Movimentacoes de vacina a partir do vacina ID e do usuário ID",
            description = "Retorna todas as movimentações referente há vacina e usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movimentação encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<List<MovimentacaoVacinaResponse>> getAllMovimentacoesVacinByVacinaIdAndUserId(@PathVariable Long id, @PathVariable Long idVacina);

}
