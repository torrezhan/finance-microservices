package ru.javabegin.finance.authservice.exception;
 
public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
} 