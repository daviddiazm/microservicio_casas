package com.daviddiazm.housing.category.domain.exceptions;

public class PublishDateExceedsException extends RuntimeException {
    public PublishDateExceedsException(String message) {
        super(message);
    }
}
