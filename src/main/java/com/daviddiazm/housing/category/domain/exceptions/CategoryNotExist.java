package com.daviddiazm.housing.category.domain.exceptions;

public class CategoryNotExist extends RuntimeException {
    public CategoryNotExist(String message) {
        super(message);
    }
}
