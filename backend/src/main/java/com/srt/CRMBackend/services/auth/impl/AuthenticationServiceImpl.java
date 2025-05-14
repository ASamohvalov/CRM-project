package com.srt.CRMBackend.services.auth.impl;

import com.srt.CRMBackend.DTO.auth.JwtDTO;
import com.srt.CRMBackend.DTO.auth.SignInRequest;
import com.srt.CRMBackend.exceptions.auth.AuthenticationFailedException;
import com.srt.CRMBackend.exceptions.auth.RefreshTokenValidationException;
import com.srt.CRMBackend.models.employees.Employee;
import com.srt.CRMBackend.models.employees.Token;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import com.srt.CRMBackend.repositories.TokenRepository;
import com.srt.CRMBackend.services.auth.AuthenticationService;
import com.srt.CRMBackend.services.auth.jwt.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtDTO signIn(SignInRequest request) {
        String errorMessage = "неправильный логин или пароль";
        Employee employee = employeeRepository.findByLogin(request.getLogin())
                .orElseThrow(() -> new AuthenticationFailedException(errorMessage));

        if (!passwordEncoder.matches(request.getPassword(), employee.getPassword())) {
            throw new AuthenticationFailedException(errorMessage);
        }

        JwtDTO jwtDto = new JwtDTO(
                jwtService.generateAccessToken(employee),
                jwtService.generateRefreshToken(employee)
        );

        Token token = Token.builder()
                .token(jwtDto.getRefreshToken())
                .employee(employee)
                .build();
        tokenRepository.save(token);

        authenticate(request);

        return jwtDto;
    }

    @Override
    @Transactional
    public JwtDTO updateTokens(String refreshToken) {
        if (!jwtService.validateRefreshToken(refreshToken)) {
            throw new RefreshTokenValidationException("срок действия токена истек");
        }

        Token token = tokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> new RefreshTokenValidationException("неправильный токен"));

        JwtDTO jwtDTO = new JwtDTO(
                jwtService.generateAccessToken(token.getEmployee()),
                jwtService.generateRefreshToken(token.getEmployee())
        );

        token.setToken(jwtDTO.getRefreshToken());
        return jwtDTO;
    }

    private void authenticate(SignInRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
