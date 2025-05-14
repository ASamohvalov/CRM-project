package com.srt.CRMBackend.services.auth.jwt.impl;

import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.services.auth.jwt.TokenService;
import com.srt.CRMBackend.services.auth.jwt.AbstractTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class RefreshTokenService extends AbstractTokenUtil implements TokenService {
    private final SecretKey secretKey;

    @Value("${token.refresh.expire-days}")
    private int tokenExpDays;

    public RefreshTokenService(
            @Value("${token.refresh.encoded-secret-key}") String encodedSecretKey
    ) {
        secretKey = stringToSecretKey(base64Decode(encodedSecretKey));
    }

    @Override
    public String generate(Employee employee) {
        return generateToken(
                employee,
                Date.from(Instant.now().plus(tokenExpDays, ChronoUnit.DAYS)),
                secretKey
        );
    }

    @Override
    public boolean validate(String token) {
        return validateToken(token, secretKey);
    }

    @Override
    public String extractSubject(String token) {
        return extractSubjectFromToken(token, secretKey);
    }
}
