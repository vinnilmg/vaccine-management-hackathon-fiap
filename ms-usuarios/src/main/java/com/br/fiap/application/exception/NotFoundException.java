package com.br.fiap.application.exception;

public class NotFoundException extends RuntimeException {

     final String resource;

    public NotFoundException(final String resource) {
        super(resource);
        this.resource = resource;
    }

    @Override
    public String getMessage() {
        return this.resource;
    }

    public static NotFoundException of(final String resource) {
        return new NotFoundException(resource);
    }
}
