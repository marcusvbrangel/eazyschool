package com.marcusvbrangel.eazyschool.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

    public ResourceAlreadyExistsException() {
        this("The resource cannot be found");
    }

}
