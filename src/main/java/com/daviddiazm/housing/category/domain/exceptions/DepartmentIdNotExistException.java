package com.daviddiazm.housing.category.domain.exceptions;

public class DepartmentIdNotExistException extends RuntimeException {
    public DepartmentIdNotExistException(String message) {
        super(message);
    }
}
