package com.scoolfy.registry.domain.error;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
