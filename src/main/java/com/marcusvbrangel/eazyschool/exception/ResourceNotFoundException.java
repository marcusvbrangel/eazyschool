package com.marcusvbrangel.eazyschool.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        this("Resource not found");
    }

}

