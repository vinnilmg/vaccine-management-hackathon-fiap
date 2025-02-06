package com.fiap.hackathon.agendamento.config.error;

public record ApiErrorResponse(
        String type,
        String message
) {
    public static ApiErrorResponse of(final Exception exception, final String message) {
        return new ApiErrorResponse(exception.getClass().getSimpleName(), message);
    }
}
