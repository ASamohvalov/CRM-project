package com.srt.CRMBackend.service.auth.impl;

import com.srt.CRMBackend.DTO.auth.JwtRequest;
import com.srt.CRMBackend.DTO.auth.SignInRequest;
import com.srt.CRMBackend.exceptions.AuthenticationFailedException;
import com.srt.CRMBackend.models.Employee;
import com.srt.CRMBackend.models.Token;
import com.srt.CRMBackend.repositories.EmployeeRepository;
import com.srt.CRMBackend.repositories.TokenRepository;
import com.srt.CRMBackend.service.auth.AuthenticationService;
import com.srt.CRMBackend.service.auth.jwt.JwtService;
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
    public JwtRequest signIn(SignInRequest request) {
        String errorMessage = "неправильный логин или пароль";
        Employee employee = employeeRepository.findByLogin(request.getLogin())
                .orElseThrow(() -> new AuthenticationFailedException(errorMessage));

        if (!passwordEncoder.matches(request.getPassword(), employee.getPassword())) {
            throw new AuthenticationFailedException(errorMessage);
        }

        JwtRequest jwtDto = new JwtRequest(
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

    private void authenticate(SignInRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
