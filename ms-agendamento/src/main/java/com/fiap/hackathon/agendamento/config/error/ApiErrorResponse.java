package com.fiap.hackathon.agendamento.config.error;

import org.springframework.web.bind.MethodArgumentNotValidException;

import static java.text.MessageFormat.format;
import static java.util.Objects.nonNull;

public record ApiErrorResponse(
        String type,
        String message
) {
    public static ApiErrorResponse of(final Exception exception, final String message) {
        return new ApiErrorResponse(exception.getClass().getSimpleName(), message);
    }

    public static ApiErrorResponse of(final MethodArgumentNotValidException exception) {
        var message = "";

        final var fieldError = exception.getBindingResult().getFieldError();
        if (nonNull(fieldError)) {
            final var field = fieldError.getField();
            final var error = fieldError.getDefaultMessage();
            message = format("{0} {1}", field, error);
        } else {
            message = exception.getMessage();
        }

        return new ApiErrorResponse(exception.getClass().getSimpleName(), message);
    }
}
