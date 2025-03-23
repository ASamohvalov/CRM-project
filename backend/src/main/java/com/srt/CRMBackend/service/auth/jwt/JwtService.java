package com.srt.CRMBackend.service.auth.jwt;

import com.srt.CRMBackend.models.Employee;

public interface JwtService {
    String generateRefreshToken(Employee employee);
    String generateAccessToken(Employee employee);

    boolean validateRefreshToken(String token);
    boolean validateAccessToken(String token);
}
