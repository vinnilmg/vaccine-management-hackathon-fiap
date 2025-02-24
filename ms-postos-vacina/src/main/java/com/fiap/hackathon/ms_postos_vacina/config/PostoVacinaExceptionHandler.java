package com.fiap.hackathon.ms_postos_vacina.config;

import com.fiap.hackathon.ms_postos_vacina.exception.PostoVacinaNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class PostoVacinaExceptionHandler {

    @ExceptionHandler(PostoVacinaNotFoundException.class)
    public ResponseEntity<Void> handleNotFoundError(final PostoVacinaNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).build();
    }
}
