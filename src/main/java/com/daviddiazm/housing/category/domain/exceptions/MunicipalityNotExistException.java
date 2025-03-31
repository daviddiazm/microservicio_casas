package com.daviddiazm.housing.category.domain.exceptions;

public class MunicipalityNotExistException extends RuntimeException {
    public MunicipalityNotExistException(String message) {
        super(message);
    }
}
