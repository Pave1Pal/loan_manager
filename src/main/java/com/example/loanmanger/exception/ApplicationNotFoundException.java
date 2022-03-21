package com.example.loanmanger.exception;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException() {
        super();
    }
    public ApplicationNotFoundException(String message) {
        super(message);
    }
}
