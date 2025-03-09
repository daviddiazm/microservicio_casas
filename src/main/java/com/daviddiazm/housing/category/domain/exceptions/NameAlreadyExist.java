package com.daviddiazm.housing.category.domain.exceptions;

public class NameAlreadyExist extends RuntimeException {
    public NameAlreadyExist(String message) {
        super(message);
    }
}
