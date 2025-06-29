package com.srt.CRMBackend.handlers;

import com.srt.CRMBackend.exceptions.CrmBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;
import java.util.UUID;

@RestControllerAdvice
public class CrmExceptionHandler {

    @ExceptionHandler(CrmBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> badRequestExceptionHandler(
            CrmBadRequestException exception) {
        return Map.of("message", exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        if (ex.getRequiredType() == UUID.class) {
            return Map.of("message", "Некорректный формат UUID: " + ex.getValue());
        }
        throw ex;
    }
}
