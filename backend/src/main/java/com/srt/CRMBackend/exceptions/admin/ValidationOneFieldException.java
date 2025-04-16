package com.srt.CRMBackend.exceptions.admin;

public class ValidationOneFieldException extends RuntimeException {
    public ValidationOneFieldException(String message) {
        super(message);
    }
}
