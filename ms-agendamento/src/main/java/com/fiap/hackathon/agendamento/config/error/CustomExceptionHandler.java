package com.fiap.hackathon.agendamento.config.error;

import com.fiap.hackathon.agendamento.domain.exceptions.CustomValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationError(final CustomValidationException e) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ApiErrorResponse.of(e, e.getMessage()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationError(final NullPointerException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ApiErrorResponse.of(e, e.getMessage()));
    }

   /* @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundError(NotFoundException e, WebRequest request) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiErrorResponse.of(e, e.getMessage()));
    }
*/

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleInternalServerError(final Exception e) {
        log.error("Erro interno: {}", e.getMessage(), e);
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ApiErrorResponse.of(e, "Internal server error"));
    }
}