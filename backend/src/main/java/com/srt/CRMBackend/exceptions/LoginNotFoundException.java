package com.srt.CRMBackend.exceptions;

public class LoginNotFoundException extends RuntimeException {
    public LoginNotFoundException(String message) {
        super(message);
    }
}
