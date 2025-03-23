package com.srt.CRMBackend.service.auth.jwt.impl;

import com.srt.CRMBackend.models.Employee;
import com.srt.CRMBackend.service.auth.jwt.TokenService;
import com.srt.CRMBackend.service.auth.jwt.AbstractTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class AccessTokenService extends AbstractTokenUtil implements TokenService {
    private final SecretKey secretKey;

    @Value("${token.access.expire-min}")
    private int tokenExpMin;

    public AccessTokenService(
            @Value("${token.access.encoded-secret-key}") String encodedSecretKey
    ) {
        secretKey = stringToSecretKey(base64Decode(encodedSecretKey));
    }

    @Override
    public String generate(Employee employee) {
        return generateToken(
                employee,
                Date.from(Instant.now().plus(tokenExpMin, ChronoUnit.MINUTES)),
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
