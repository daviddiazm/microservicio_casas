package com.daviddiazm.housing.category.domain.exceptions;

public class MinLengthException extends RuntimeException {
    public MinLengthException(String message) {
        super(message);
    }
}
