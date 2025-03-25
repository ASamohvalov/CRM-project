package com.srt.CRMBackend.handlers;

import com.srt.CRMBackend.exceptions.AuthenticationFailedException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class AuthenticationExceptionHandler {

    @ExceptionHandler(AuthenticationFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> authenticationFailedExceptionHandler(
            AuthenticationFailedException exception) {
        return Map.of("message", exception.getMessage());
    }
}
