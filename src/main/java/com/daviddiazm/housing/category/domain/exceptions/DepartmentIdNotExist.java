package com.daviddiazm.housing.category.domain.exceptions;

public class DepartmentIdNotExist extends RuntimeException {
    public DepartmentIdNotExist(String message) {
        super(message);
    }
}
