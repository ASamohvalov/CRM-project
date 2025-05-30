package com.srt.CRMBackend.services.auth.jwt;

import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.employees.FullName;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

public abstract class AbstractTokenUtil {

    protected String generateToken(Employee employee, Date exp, SecretKey secretKey) {
        FullName fullName = employee.getFullName();

        Map<String, String> claims = Map.of(
                "email", employee.getEmail(),
                "firstName", fullName.getFirstName(),
                "lastName", fullName.getLastName(),
                "patronymic", fullName.getPatronymic()
        );

        return Jwts.builder()
                .subject(employee.getLogin())
                .claims(claims)
                .issuedAt(Date.from(Instant.now()))
                .expiration(exp)
                .signWith(secretKey)
                .compact();
    }

    protected boolean validateToken(String token, SecretKey secretKey) {
        try {
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parse(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    protected String extractSubjectFromToken(String token, SecretKey secretKey) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    protected SecretKey stringToSecretKey(String secretKey) {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    protected String base64Decode(String str) {
        return new String(
                Base64.getDecoder().decode(str.getBytes(StandardCharsets.UTF_8))
        );
    }
}
