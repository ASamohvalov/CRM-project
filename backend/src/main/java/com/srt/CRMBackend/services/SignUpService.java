package com.srt.CRMBackend.services;

import com.srt.CRMBackend.DTO.SignUpRequest;
import com.srt.CRMBackend.exceptions.LoginAlreadyExistsException;
import com.srt.CRMBackend.models.Employee;
import com.srt.CRMBackend.models.Role;
import com.srt.CRMBackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpRequest request) {
        if (userRepository.existsByLogin(request.getLogin())) {
            throw new LoginAlreadyExistsException("такой логин уже занят");
        }

        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_WORKER);

        Employee employee = Employee.builder()
                .login(request.getLogin())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();

        userRepository.save(employee);
    }
}
