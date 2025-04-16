package com.srt.CRMBackend.exceptions.admin;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class ValidationException extends RuntimeException {
    private Map<String, String> errors;

    public ValidationException(Map<String, String> errors) {
        this.errors = errors;
    }
}
