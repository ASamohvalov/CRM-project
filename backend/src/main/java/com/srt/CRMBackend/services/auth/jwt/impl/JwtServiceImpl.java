package com.srt.CRMBackend.services.auth.jwt.impl;

import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.services.auth.jwt.JwtService;
import com.srt.CRMBackend.services.auth.jwt.TokenService;
import com.srt.CRMBackend.services.auth.jwt.AbstractTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {
    @Autowired
    @Qualifier("accessTokenService")
    private TokenService accessTokenService;

    @Autowired
    @Qualifier("refreshTokenService")
    private TokenService refreshTokenService;

    @Override
    public String generateRefreshToken(Employee employee) {
        return refreshTokenService.generate(employee);
    }

    @Override
    public String generateAccessToken(Employee employee) {
        return accessTokenService.generate(employee);
    }

    @Override
    public boolean validateRefreshToken(String token) {
        return refreshTokenService.validate(token);
    }

    @Override
    public boolean validateAccessToken(String token) {
        return accessTokenService.validate(token);
    }
}
