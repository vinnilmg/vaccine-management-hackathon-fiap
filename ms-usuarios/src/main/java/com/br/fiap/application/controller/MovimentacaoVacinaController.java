package com.br.fiap.application.controller;

import com.br.fiap.application.dto.request.MovimentacaoVacinaRequest;
import com.br.fiap.application.dto.response.MovimentacaoVacinaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "MovimentacaoVacina", description = "Operações relacionadas à movimentação de vacinas")
public interface MovimentacaoVacinaController {

    @Operation(
            summary = "Listar todas as movimentações de vacinas",
            description = "Retorna uma lista de todas as movimentações de vacinas cadastradas."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de movimentações de vacinas retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<List<MovimentacaoVacinaResponse>> getAllMovimentacoes();

    @Operation(
            summary = "Buscar movimentação de vacina por ID",
            description = "Retorna uma movimentação de vacina com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movimentação de vacina encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Movimentação de vacina não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<MovimentacaoVacinaResponse> getMovimentacaoById(Long id);

    @Operation(
            summary = "Buscar movimentação de vacina por ID do Usuário",
            description = "Retorna uma movimentação de vacina com base no ID do Usuário."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movimentação de vacina encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Movimentação de vacina não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<List<MovimentacaoVacinaResponse>> getMovimentacaoByIdUsuario(Long id);

    @Operation(
            summary = "Criar uma nova movimentação de vacina",
            description = "Cria uma nova movimentação de vacina com os dados fornecidos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movimentação de vacina criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<MovimentacaoVacinaResponse> createMovimentacao(MovimentacaoVacinaRequest movimentacaoVacina);

    @Operation(
            summary = "Atualizar uma movimentação de vacina",
            description = "Atualiza os dados de uma movimentação de vacina existente com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movimentação de vacina atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Movimentação de vacina não encontrada"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    ResponseEntity<MovimentacaoVacinaResponse> updateMovimentacao(Long id, MovimentacaoVacinaRequest movimentacaoVacina);

    @Operation(
            summary = "Excluir uma movimentação de vacina",
            description = "Exclui uma movimentação de vacina com base no ID fornecido."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movimentação de vacina excluída com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    ResponseEntity<Void> deleteMovimentacao(Long id);


    @Operation(
            summary = "Listar movimentações de vacina dos dependentes por meio do ID do Titular.",
            description = "Listagem de movimentações de vacina dos dependentes por meio do ID do Titular."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movimentações de Vacina do Dependente listada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno")
    })
    ResponseEntity<List<MovimentacaoVacinaResponse>> getAllMovimentacaoVacinaDependentesByUserId(Long userid);
}