package com.daviddiazm.housing.category.domain.exceptions;

public class MaxLengthException extends RuntimeException {
    public MaxLengthException(String message) {
        super(message);
    }
}
