package com.srt.CRMBackend.service.auth.jwt;

import com.srt.CRMBackend.models.Employee;

public interface TokenService {
    String generate(Employee employee);
    boolean validate(String token);
    String extractSubject(String token);
}
