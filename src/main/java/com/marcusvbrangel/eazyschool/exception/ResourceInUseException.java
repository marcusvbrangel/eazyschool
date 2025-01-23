package com.marcusvbrangel.eazyschool.exception;

public class ResourceInUseException extends RuntimeException {

    public ResourceInUseException(String message) {
        super(message);
    }

    public ResourceInUseException() {
        this("The resource cannot be found");
    }
}
