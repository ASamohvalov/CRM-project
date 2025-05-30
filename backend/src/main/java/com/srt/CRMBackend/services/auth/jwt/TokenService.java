package com.srt.CRMBackend.services.auth.jwt;

import com.srt.CRMBackend.models.employees.Employee;

public interface TokenService {
    String generate(Employee employee);
    boolean validate(String token);
    String extractSubject(String token);
}
