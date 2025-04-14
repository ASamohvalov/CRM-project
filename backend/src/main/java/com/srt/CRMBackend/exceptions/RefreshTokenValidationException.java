package com.srt.CRMBackend.exceptions;

public class RefreshTokenValidationException extends RuntimeException {
  public RefreshTokenValidationException(String message) {
    super(message);
  }
}
