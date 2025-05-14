package com.srt.CRMBackend.handlers;

import com.srt.CRMBackend.exceptions.CrmBadRequestException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class CrmExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> badRequestExceptionHandler(
            CrmBadRequestException exception) {
        return Map.of("message", exception.getMessage());
    }
}
