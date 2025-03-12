package com.daviddiazm.housing.category.domain.exceptions;

public class CategoryAlreadyExist extends RuntimeException {
    public CategoryAlreadyExist(String message) {
        super(message);
    }
}
