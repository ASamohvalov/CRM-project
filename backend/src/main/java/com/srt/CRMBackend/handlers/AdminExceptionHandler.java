package com.srt.CRMBackend.handlers;

import com.srt.CRMBackend.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class AdminExceptionHandler {

    @ExceptionHandler(value = ValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> FieldAlreadyTakenExceptionHandler(ValidationException exception) {
        return exception.getErrors();
    }
}
