package com.srt.CRMBackend.service.auth.jwt.impl;

import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.service.auth.jwt.JwtService;
import com.srt.CRMBackend.service.auth.jwt.TokenService;
import com.srt.CRMBackend.service.auth.jwt.AbstractTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl extends AbstractTokenUtil implements JwtService {
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
