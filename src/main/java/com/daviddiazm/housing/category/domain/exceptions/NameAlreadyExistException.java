package com.daviddiazm.housing.category.domain.exceptions;

public class NameAlreadyExistException extends RuntimeException {
    public NameAlreadyExistException(String message) {
        super(message);
    }
}
