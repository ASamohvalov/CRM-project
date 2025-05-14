package com.srt.CRMBackend.exceptions;

public class CrmBadRequestException extends RuntimeException {
    public CrmBadRequestException(String message) {
        super(message);
    }
}
