package com.fiap.hackathon.agendamento.config.error;

import com.fiap.hackathon.agendamento.domain.exceptions.AgendamentoAlreayExistsException;
import com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException;
import com.fiap.hackathon.agendamento.domain.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({
            CustomValidationException.class,
            NullPointerException.class,
            AgendamentoAlreayExistsException.class,
    })
    public ResponseEntity<ApiErrorResponse> handleValidationError(final Exception e) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ApiErrorResponse.of(e, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidError(final MethodArgumentNotValidException e) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ApiErrorResponse.of(e));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundError(final NotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(ApiErrorResponse.of(e, e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleInternalServerError(final Exception e) {
        log.error("Erro interno: {}", e.getMessage(), e);
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ApiErrorResponse.of(e, "Internal server error"));
    }
}