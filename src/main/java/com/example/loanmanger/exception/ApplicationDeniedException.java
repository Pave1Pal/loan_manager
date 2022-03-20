package com.example.loanmanger.exception;

public class ApplicationDeniedException extends RuntimeException {
    public ApplicationDeniedException(String message) {
        super(message);
    }
}
