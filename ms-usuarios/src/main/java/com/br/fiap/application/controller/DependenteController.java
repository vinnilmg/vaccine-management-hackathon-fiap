package com.br.fiap.application.controller;

import com.br.fiap.application.dto.request.DependenteRequest;
import com.br.fiap.core.model.Dependente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Dependente", description = "Operações relacionadas a dependentes")
public interface DependenteController {

    @Operation(
            summary = "Listar todos os dependentes",
            description = "Retorna uma lista de todos os dependentes cadastrados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de dependentes retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<List<Dependente>> getAllDependentes();

    @Operation(
            summary = "Buscar dependente por ID",
            description = "Retorna um dependente com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dependente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dependente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<Dependente> getDependenteById(Long id);

    @Operation(
            summary = "Criar um novo dependente",
            description = "Cria um novo dependente com os dados fornecidos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dependente criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<Dependente> createDependente(DependenteRequest dependenteRequest);

    @Operation(
            summary = "Atualizar um dependente",
            description = "Atualiza os dados de um dependente existente com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dependente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dependente não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<Dependente> updateDependente(Long id, DependenteRequest dependenteRequest);

    @Operation(
            summary = "Excluir um dependente",
            description = "Exclui um dependente com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Dependente excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dependente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<Void> deleteDependente(Long id);
}