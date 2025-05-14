package com.srt.CRMBackend.services.auth.jwt;

import com.srt.CRMBackend.models.employees.Employee;

public interface JwtService {
    String generateRefreshToken(Employee employee);
    String generateAccessToken(Employee employee);

    boolean validateRefreshToken(String token);
    boolean validateAccessToken(String token);
}
