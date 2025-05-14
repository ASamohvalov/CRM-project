package com.srt.CRMBackend.exceptions.auth;

public class RefreshTokenValidationException extends RuntimeException {
  public RefreshTokenValidationException(String message) {
    super(message);
  }
}
