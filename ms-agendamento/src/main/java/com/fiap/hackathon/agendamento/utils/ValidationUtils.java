package com.fiap.hackathon.agendamento.utils;

import java.util.function.Predicate;

import static java.util.Objects.isNull;

public class ValidationUtils {

    private ValidationUtils() {
    }

    public static Predicate<Long> isNullOrLessThanZero() {
        return l -> isNull(l) || l <= 0;
    }
}
